import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/7/21 22:35 <br>
 */
public class WebServer {

    public void run() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            byte[] buffer = new byte[8096];
            int hasRead = inputStream.read(buffer);
            System.out.println(new String(buffer, 0, hasRead));
            String response = "HTTP/1.1 200\r\n" + "Content-Type: text/html\r\n"
                    + "Date: Thu, 21 Jul 2022 15:34:34 GMT\r\n" + "Keep-Alive: timeout=60\r\n"
                    + "Connection: keep-alive\r\n"
                    + "\r\n" + "real content";
            byte[] bytes = response.getBytes();
            outputStream.write(bytes);
            socket.close();
        }
    }


    public static void main(String[] args) throws Exception {
        WebServer webServer = new WebServer();
        webServer.run();
    }

}
