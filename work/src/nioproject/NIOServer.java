package nioproject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/8/5 21:25 <br>
 */
public class NIOServer {

    void test() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 30003);
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        //ServerSocket serverSocket = new ServerSocket();
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) {

    }

}
