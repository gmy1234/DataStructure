package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gmydl
 * @title: test
 * @projectName DataStructure
 * @description: TODO
 * @date 2022/6/10 21:15
 */
public class test {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9123);
        System.out.println("等待客户端的链接");
        Socket client = serverSocket.accept();

        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("hello");
        out.println("你好");
        client.close();
        serverSocket.close();;
    }
}
