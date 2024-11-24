package cn.xf.TCP.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9292);

        // 等待连接
        Socket accept = socket.accept();

        // 获取输入流
        InputStream stream = accept.getInputStream();
        // 转为字符流
        InputStreamReader reader = new InputStreamReader(stream);
        // 提高读取效率
        BufferedReader br = new BufferedReader(reader);
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }
        accept.close();
        stream.close();
    }
}
