package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gmydl
 * @title: EchoClient
 * @projectName DataStructure
 * @description: 客户端
 * @date 2022/6/10 21:06
 */
public class EchoClient {

    private ServerSocket serverSocket ;



    public EchoClient(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
    }

    //开始等待并接受客户端连接
    public void run() throws IOException {
        //等待客户端的信息   如果客户端长时间没有与它建立连接  将会抛出异常 异常是在jdk中封装了的
        assert serverSocket != null;
        Socket client = serverSocket.accept();
        //进行socket通信处理

    }
}
