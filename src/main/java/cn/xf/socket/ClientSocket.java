package cn.xf.socket;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
//        String serverName = args[0];
//        Integer port = Integer.parseInt(args[1]);
        String serverName = "localhost";
        Integer port = 6066;
        try {
            // 创建socket连接对象
            Socket socket = new Socket(serverName, port);
            // 获取远程主机地址
            System.out.println("远程主机地址为："+socket.getRemoteSocketAddress());
            // 获取连接输出流
            OutputStream outputServer = socket.getOutputStream();
            // 使用连接输出流创建数据输出流
            DataOutputStream outputStream = new DataOutputStream(outputServer);
            // -----

            outputStream.writeUTF("数据从这里来："+socket.getLocalSocketAddress());
            // 获取连接输入流
            InputStream inputServer = socket.getInputStream();
            // 使用连接输入流创建数据输入流
            DataInputStream dataInputStream = new DataInputStream(inputServer);
            // 获取服务端响应数据
            System.out.println("服务器响应数据："+dataInputStream.readUTF());

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
