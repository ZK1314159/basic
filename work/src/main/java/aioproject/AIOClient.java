package main.java.aioproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.*;
import java.awt.geom.*;

public class AIOClient {
    final static String UTF_8 = "utf-8";
    final static int PORT = 30002;
    // 与服务器端通信的异步Channel
    AsynchronousSocketChannel clientChannel;
    Map<String, ChatFrame> map = new HashMap<>();
    String localName;
    String localImage;
    MainWin main;

    public static void main(String[] args) throws Exception {
        AIOClient client = new AIOClient();
        client.connect();
    }

    public void connect() throws Exception {
        //定义一个ByteBuffer准备读取数据
        final ByteBuffer buff = ByteBuffer.allocate(1024);
        //创建AsynchronousSocketChannel
        clientChannel = AsynchronousSocketChannel.open();
        // 让AsynchronousSocketChannel连接到指定IP、指定端口
        clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
        System.out.println("---与服务器连接成功---\n");

        //用户注册和选择头像
        register(buff, clientChannel);

        main = new MainWin();
        buff.clear();
        clientChannel.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                // 将buff中内容转换为字符串
                String content = StandardCharsets.UTF_8.decode(buff).toString();
                // 显示从服务器端读取的数据
                if (content.startsWith(Protocol.USER_LIST) && content.endsWith(Protocol.USER_LIST)) {
                    //绘制用户列表
                    String userList = getRealMsg(content);
                    Set<String[]> set = getList(userList);
                    main.listModel.removeAllElements();
                    String[] st = {"群聊", "icon/all.gif"};
                    main.listModel.addElement(st);
                    for (String[] s : set) {
                        main.listModel.addElement(s);
                    }
                    main.setVisible(true);
                }
                if (content.startsWith(Protocol.CHAT_PRIVATE) && content.endsWith(Protocol.CHAT_PRIVATE)) {
                    //向用户提供信息
                    String inf = getRealMsg(content);
                    String userSend = inf.split(Protocol.SPLIT_SIGN)[0];
                    String userAccept = inf.split(Protocol.SPLIT_SIGN)[1];
                    String con = inf.split(Protocol.SPLIT_SIGN)[2];
                    if (userSend.equals(localName)) {
                        map.get(userAccept).jta.append("我" + "：" + con + "\n");
                    } else {
                        map.get(userSend).jta.append(userSend + "：" + con + "\n");
                    }
                }
                if (content.startsWith(Protocol.CHAT_PUBLIC) && content.endsWith(Protocol.CHAT_PUBLIC)) {
                    //向用户提供信息
                    String inf = getRealMsg(content);
                    map.get("群聊").jta.append(inf + "\n");
                }
                buff.clear();
                clientChannel.read(buff, null, this);
            }

            @Override
            public void failed(Throwable ex, Object attachment) {
                System.out.println("读取数据失败: " + ex);
            }

            private String getRealMsg(String content) {
                return content.substring(Protocol.PROTOCOL_LEN, content.length() - Protocol.PROTOCOL_LEN);
            }

            Set<String[]> getList(String userList) {
                String[] st = userList.split(Protocol.SPLIT_SIGN);
                Set<String[]> set = new HashSet<>();
                for (int i = 0; i < st.length; i++) {
                    if (!(st[i].split(Protocol.SPLIT_SIGN2)[0]).equals(localName)) {
                        set.add(st[i].split(Protocol.SPLIT_SIGN2));
                    }
                }
                return set;
            }
        });
    }

    private void register(ByteBuffer buff, AsynchronousSocketChannel clientChannel) throws Exception {
        String tip = "";
        while (true) {
            localName = JOptionPane.showInputDialog(null, tip + "输入用户名");
            // 将用户输入的用户名的前后增加协议字符串后发送
            clientChannel.write(ByteBuffer.wrap((Protocol.USER_NAME + localName + Protocol.USER_NAME)
                    .getBytes(AIOClient.UTF_8))).get();
            // 读取服务器的响应
            buff.clear();
            clientChannel.read(buff).get();
            buff.flip();
            String result = Charset.forName("utf-8").decode(buff).toString();
            // 如果用户重复，开始下次循环
            if (result.equals(Protocol.NAME_REP)) {
                tip = "用户名重复！请重新";
                continue;
            }
            // 如果服务器返回登录成功，结束循环
            if (result.equals(Protocol.LOGIN_SUCCESS)) {
                break;
            }
        }
        ImageIcon im = (ImageIcon) JOptionPane.showInputDialog(null, "请选择用户头像", "输入", JOptionPane.QUESTION_MESSAGE
                , null, new ImageIcon[]{new ImageIcon("icon/1.gif"), new ImageIcon("icon/2.gif")
                , new ImageIcon("icon/3.gif"), new ImageIcon("icon/4.gif"), new ImageIcon("icon/5.gif")
                , new ImageIcon("icon/6.gif"), new ImageIcon("icon/7.gif"), new ImageIcon("icon/8.gif")
                , new ImageIcon("icon/9.gif"), new ImageIcon("icon/10.gif")}, new ImageIcon("icon/1.gif"));
        String s = im.toString();
        localImage = s;
        clientChannel.write(ByteBuffer.wrap((Protocol.USER_IMAGE + localName + Protocol.SPLIT_SIGN + s
                + Protocol.USER_IMAGE).getBytes(AIOClient.UTF_8))).get();
    }

    class MainWin extends JFrame {
        DefaultListModel<String[]> listModel = new DefaultListModel<>();
        JList<String[]> list = new JList<>(listModel);

        public MainWin() {
            super(localName + "的聊天");
            list.setCellRenderer(new ImageCellRenderer());
            list.addMouseListener(new ChangeMusicListener());
            add(new JScrollPane(list));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(30, 30, 240, 600);
        }
    }

    class ChatFrame extends JFrame {
        String userName;
        JTextArea jta;
        JTextField jtf;
        JButton sendBn;

        public ChatFrame(String user, String title) {
            super(title);
            userName = user;
            jta = new JTextArea(16, 48);
            jta.setEditable(false);
            add(new JScrollPane(jta));
            jtf = new JTextField(40);
            sendBn = new JButton("发送");
            JPanel jp = new JPanel();
            jp.add(jtf);
            jp.add(sendBn);
            sendBn.addActionListener(sendAction);
            jtf.getInputMap().put(KeyStroke.getKeyStroke('\n', java.awt.event.InputEvent.CTRL_DOWN_MASK), "send");
            // 将"send"和sendAction关联
            jtf.getActionMap().put("send", sendAction);
            add(jp, BorderLayout.SOUTH);
            setLocation(50, 50);
            pack();
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
        }

        Action sendAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!userName.equals("群聊")) {
                        clientChannel.write(ByteBuffer.wrap((Protocol.CHAT_PRIVATE + userName + Protocol.SPLIT_SIGN
                                + jtf.getText() + Protocol.CHAT_PRIVATE).getBytes(AIOClient.UTF_8))).get();
                    } else {
                        clientChannel.write(ByteBuffer.wrap((Protocol.CHAT_PUBLIC + jtf.getText()
                                + Protocol.CHAT_PUBLIC).getBytes(AIOClient.UTF_8))).get();
                    }
                } catch (Exception ex) {
                }
                // 清空输入框
                jtf.setText("");
            }
        };
    }

    class ChangeMusicListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            // 如果鼠标的击键次数大于2
            if (e.getClickCount() >= 2) {
                // 取出鼠标双击时选中的列表项
                String[] userinfor = main.list.getSelectedValue();
                String user = userinfor[0];
                if (map.containsKey(user)) {
                    map.get(user).setVisible(true);
                }
                // 为该用户创建一个交谈窗口
                if (!map.containsKey(user)) {
                    if (user.equals("群聊")) {
                        ChatFrame chat = new ChatFrame("群聊", "群聊");
                        map.put(user, chat);
                    } else {
                        ChatFrame chat = new ChatFrame(user, "与" + user + "的聊天");
                        map.put(user, chat);
                    }
                }
            }
        }
    }

    class ImageCellRenderer extends JPanel implements ListCellRenderer<String[]> {
        private ImageIcon icon;
        private String name;
        // 定义绘制单元格时的背景色
        private Color background;
        // 定义绘制单元格时的前景色
        private Color foreground;

        public Component getListCellRendererComponent(JList list, String[] value, int index, boolean isSelected
                , boolean cellHasFocus) {
            icon = new ImageIcon(value[1]);
            name = value[0];
            background = isSelected ? list.getSelectionBackground() : list.getBackground();
            foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
            // 返回该JPanel对象作为列表项绘制器
            return this;
        }

        // 重写paintComponent方法，改变JPanel的外观
        public void paintComponent(Graphics g) {
            int imageWidth = icon.getImage().getWidth(null);
            int imageHeight = icon.getImage().getHeight(null);
            g.setColor(background);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(foreground);
            // 绘制好友图标
            g.drawImage(icon.getImage(), getWidth() / 2 - imageWidth / 2, 10, null);
            g.setFont(new Font("SansSerif", Font.BOLD, 18));
            // 绘制好友用户名
            Font font = new Font("SansSerif", Font.BOLD, 18);
            FontMetrics metrics = new FontMetrics(font) {
            };
            Rectangle2D bounds = metrics.getStringBounds(name, null);
            int width = (int) bounds.getWidth();
            g.drawString(name, getWidth() / 2 - width / 2, imageHeight + 30);
        }

        // 通过该方法来设置该ImageCellRenderer的最佳大小
        public Dimension getPreferredSize() {
            return new Dimension(60, 80);
        }
    }
}