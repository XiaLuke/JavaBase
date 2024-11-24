package cn.xf.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class PractiesSend {
    public static void main(String[] args) throws IOException {
        // 创建 DatagramSocket 对象
        DatagramSocket socket = new DatagramSocket();
        // 打包数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();
            if(msg.equals("exit")){
                break;
            }
            byte[] data = msg.getBytes();
            int port = 9191;
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            // 发送数据
            socket.send(packet);
        }

        // 释放资源
        socket.close();
    }
}
