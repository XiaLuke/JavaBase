package cn.xf.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMsg {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        // 接收数据包
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // 阻塞接收
        socket.receive(packet);

        // 解析数据
        byte[] bytes = packet.getData();
        int length = packet.getLength();
        InetAddress address = packet.getAddress();
        int port = packet.getPort();

        String str = new String(bytes,0,length);
        System.out.println("收到的数据为："+str);
        System.out.println("发送方的地址为："+address);
        System.out.println("发送方的端口为："+port);


        socket.close();
    }
}
