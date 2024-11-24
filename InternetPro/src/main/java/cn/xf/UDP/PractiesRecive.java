package cn.xf.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class PractiesRecive {
    public static void main(String[] args) throws IOException {
        // 创建 DatagramSocket 对象
        DatagramSocket socket = new DatagramSocket(9191);

        while (true) {
            // 接收数据包
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);

            // 解析数据包
            byte[] bytes = packet.getData();
            int length = packet.getLength();
            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            System.out.println("address发送:\n" + new String(bytes, 0, length));
        }

    }
}
