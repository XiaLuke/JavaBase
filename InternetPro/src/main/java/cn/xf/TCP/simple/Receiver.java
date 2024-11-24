package cn.xf.TCP.simple;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9292);

        // 等待连接
        Socket accept = socket.accept();

        // 获取输入流
        InputStream stream = accept.getInputStream();
        int b;
        while ((b = stream.read()) != -1) {
            System.out.println((char) b);
        }
        accept.close();
        stream.close();
    }
}
