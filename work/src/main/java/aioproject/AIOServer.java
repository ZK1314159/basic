package aioproject;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.concurrent.*;
import javax.swing.*;
import java.awt.*;

public class AIOServer {
    static final int PORT = 30002;
    final static String UTF_8 = "utf-8";
    public static ClientInformation<String, AsynchronousSocketChannel> clients = new ClientInformation<>();

    public void startListen() throws InterruptedException, Exception {
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(20);
        // 以指定线程池来创建一个AsynchronousChannelGroup
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        // 以指定AsynchronousChannelGroup来创建一个AsynchronousServerSocketChannel
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(channelGroup)
                // 指定监听本机的PORT端口
                .bind(new InetSocketAddress(PORT));
        // 使用CompletionHandler接受来自客户端的连接请求
        serverChannel.accept(null, new AcceptHandler(serverChannel));
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("服务器");
        JLabel jl = new JLabel("   深藏功与名的服务器！");
        jf.add(jl);
        jl.setFont(new Font("Serif", 0, 25));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocation(30, 30);
        jf.setSize(300, 200);
        jf.setVisible(true);
        AIOServer server = new AIOServer();
        server.startListen();
    }
}

// 实现自己的CompletionHandler类
class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    private AsynchronousServerSocketChannel serverChannel;

    public AcceptHandler(AsynchronousServerSocketChannel sc) {
        this.serverChannel = sc;
    }

    // 定义一个ByteBuffer准备读取数据
    ByteBuffer buff = ByteBuffer.allocate(1024);

    // 当实际IO操作完成时候触发该方法
    @Override
    public void completed(final AsynchronousSocketChannel sc, Object attachment) {
        // 准备接受客户端的下一次连接
        serverChannel.accept(null, this);
        sc.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                // 将buff中内容转换为字符串
                String content = StandardCharsets.UTF_8.decode(buff).toString(); //用StandardCharsets的方法不用写异常声明

                //重写completed方法时不能抛出异常，因为父类没有声明异常，子类就不能抛出异常
                try {

                    if (content.startsWith(Protocol.USER_NAME) && content.endsWith(Protocol.USER_NAME)) {
                        // 得到真实消息
                        String userName = getRealMsg(content);
                        // 如果用户名重复
                        if (AIOServer.clients.map.containsKey(userName)) {
                            System.out.println("用户名重复");
                            sc.write(ByteBuffer.wrap(Protocol.NAME_REP.getBytes(AIOServer.UTF_8))).get();
                        } else {
                            System.out.println("注册成功");
                            sc.write(ByteBuffer.wrap(Protocol.LOGIN_SUCCESS.getBytes(AIOServer.UTF_8))).get();
                            AIOServer.clients.put(userName, sc);
                        }
                    } else if (content.startsWith(Protocol.USER_IMAGE) && content.endsWith(Protocol.USER_IMAGE)) {
                        // 得到真实消息
                        String user = getRealMsg(content);
                        //协议字符出错导致字符分解错误
                        String userName = user.split(Protocol.SPLIT_SIGN)[0];
                        String userImage = user.split(Protocol.SPLIT_SIGN)[1];
                        AIOServer.clients.map2.put(userName, userImage);
                        //向所有用户提供当前用户列表
                        String userList = "";
                        for (String key : AIOServer.clients.map2.keySet()) {
                            userList = userList + key + Protocol.SPLIT_SIGN2 + AIOServer.clients.map2.get(key)
                                    + Protocol.SPLIT_SIGN;
                        }
                        for (AsynchronousSocketChannel clientSc : AIOServer.clients.valueSet()) {
                            clientSc.write(ByteBuffer.wrap((Protocol.USER_LIST + userList
                                    + Protocol.USER_LIST).getBytes(AIOServer.UTF_8))).get();
                        }
                    }
                    // 如果读到的行以Protocol.CHAT_PRIVATE开始，并以其结束，
                    // 可以确定是私聊信息，私聊信息只向特定的Socket发送
                    else if (content.startsWith(Protocol.CHAT_PRIVATE) && content.endsWith(Protocol.CHAT_PRIVATE)) {
                        // 得到真实消息
                        String userAndMsg = getRealMsg(content);
                        // 以SPLIT_SIGN分割字符串，前半是私聊用户，后半是聊天信息
                        String user = userAndMsg.split(Protocol.SPLIT_SIGN)[0];
                        String msg = userAndMsg.split(Protocol.SPLIT_SIGN)[1];
                        // 获取私聊用户对应的Socket，并发送私聊信息
                        AIOServer.clients.map.get(user).write(ByteBuffer.wrap((Protocol.CHAT_PRIVATE
                                + AIOServer.clients.getKeyByValue(sc) + Protocol.SPLIT_SIGN + user
                                + Protocol.SPLIT_SIGN + msg + Protocol.CHAT_PRIVATE).getBytes(AIOServer.UTF_8))).get();
                        sc.write(ByteBuffer.wrap((Protocol.CHAT_PRIVATE + AIOServer.clients.getKeyByValue(sc)
                                + Protocol.SPLIT_SIGN + user + Protocol.SPLIT_SIGN + msg
                                + Protocol.CHAT_PRIVATE).getBytes(AIOServer.UTF_8))).get();
                    }
                    // 公聊要向每个Socket发送
                    else {
                        // 得到真实消息
                        String msg = getRealMsg(content);
                        // 遍历clients中的每个Socket
                        for (AsynchronousSocketChannel clientSc : AIOServer.clients.valueSet()) {
                            clientSc.write(ByteBuffer.wrap((Protocol.CHAT_PUBLIC
                                    + AIOServer.clients.getKeyByValue(sc) + "：" + msg
                                    + Protocol.CHAT_PUBLIC).getBytes(AIOServer.UTF_8))).get();
                        }
                    }

                } catch (Exception ex) {
                }
                buff.clear();
                // 读取下一次数据
                sc.read(buff, null, this);
            }

            @Override
            public void failed(Throwable ex, Object attachment) {
                try {
                    System.out.println("读取数据失败2: " + ex);
                    // 从该Channel读取数据失败，就将该Channel删除
                    String value2 = AIOServer.clients.getKeyByValue(sc);
                    AIOServer.clients.map.remove(value2);
                    AIOServer.clients.map2.remove(value2);
                    //向所有用户提供当前用户列表
                    String userList = "";
                    for (String key : AIOServer.clients.map2.keySet()) {
                        userList = userList + key + Protocol.SPLIT_SIGN2 + AIOServer.clients.map2.get(key)
                                + Protocol.SPLIT_SIGN;
                    }
                    // 遍历clients中的每个Socket
                    for (AsynchronousSocketChannel clientSc : AIOServer.clients.valueSet()) {
                        clientSc.write(ByteBuffer.wrap((Protocol.USER_LIST + userList
                                + Protocol.USER_LIST).getBytes(AIOServer.UTF_8))).get();
                    }
                } catch (Exception e) {
                }
            }

            private String getRealMsg(String content) {
                return content.substring(Protocol.PROTOCOL_LEN, content.length() - Protocol.PROTOCOL_LEN);
            }
        });
    }

    @Override
    public void failed(Throwable ex, Object attachment) {
        System.out.println("连接失败: " + ex);
    }
}