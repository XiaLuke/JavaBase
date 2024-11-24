package cn.xf.TCP.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

// 客户端
public class Sender {
    public static void main(String[] args) throws IOException {
        // 创建socket
        Socket socket = new Socket("127.0.0.1",9292);

        // 从链接通过到获取输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hei boy".getBytes());

        socket.close();
    }
}
