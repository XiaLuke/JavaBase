package cn.xf.Practies1.ReceiveAndRecall;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// 发送数据，接收服务端返回的消息
public class Sender {
    public static void main(String[] args) throws IOException {
        // 创建Socket对象，连接服务器
        Socket socket = new Socket("127.0.0.1", 9292);

        // 获取输出流
        OutputStream outputStream = socket.getOutputStream();

        // 从键盘中获取数据
        Scanner scanner = new Scanner(System.in);
//        while (true) {
        System.out.println("发送的消息：");
        String msg = scanner.nextLine();
//            if ("exit".equals(msg)) {
//                break;
//            }
        outputStream.write(msg.getBytes());
        socket.shutdownOutput();
        // 反馈
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);

        }
//        }


        socket.close();
        scanner.close();
    }
}
