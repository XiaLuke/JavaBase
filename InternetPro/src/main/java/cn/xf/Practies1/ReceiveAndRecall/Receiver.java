package cn.xf.Practies1.ReceiveAndRecall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 接收数据并给客户端反馈数据
public class Receiver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9292);

        Socket accept = serverSocket.accept();
        // 从serverScoket中读取数据，并使用包装提高效率
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);

        }
        // 返回反馈数据
        accept.getOutputStream().write("收到消息".getBytes());
        System.out.println("已反馈");
        // 释放资源
        accept.close();
        serverSocket.close();
    }
}
