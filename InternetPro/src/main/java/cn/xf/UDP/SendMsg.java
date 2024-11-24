package cn.xf.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendMsg {
    public static void main(String[] args) throws IOException {
        DatagramSocket sock = new DatagramSocket();

        String str = "hello world";
        byte[] data = str.getBytes();
        InetAddress name = InetAddress.getByName("127.0.0.1");
        int port = 9999;

        DatagramPacket packet = new DatagramPacket(data, data.length, name, port);

        sock.send(packet);

        sock.close();
    }
}
