package cn.xf.day8_inter_connection;

import cn.xf._01String.Stringbuffer_;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 网络通信：基本架构：C/S（Client/Server），B/S（Browser/Server）
 * <p>
 * java中通过java.net包下的类实现网络通信
 * 网络通信要素：IP，端口，协议
 * - IP：设备在网络中的唯一标识
 * - 端口：应用程序的唯一标识
 * - 协议：连接和数据在网络中传输协议
 * <p>
 * IPV4：32位，
 * IPV6：128位
 * <p>
 * IP域名：域名通过DNS域名解析器得到IP地址
 * <p>
 * 公网IP：连接互联网的IP
 * 内网IP：局域网IP，范围在192.168.0.0~192.168.255.255
 */
public class MyConnection {
    public static void main(String[] args) throws UnknownHostException {
        // 通过java.net包中获取本机ip地址
        InetAddress localHost = InetAddress.getLocalHost();

        // 获取域名对应的Ip地址
        InetAddress byName = InetAddress.getByName("www.rumanhua.com");
        System.out.println(byName.getHostName()); // www.rumanhua.com
        System.out.println(byName.getHostAddress()); // 23.224.95.57

        // 端口：0~65535，0~1023为系统端口，1024~49151为用户端口，49152~65535为保留端口

        // 协议：网络上通信设备，按照规则进行连接和数据传输
        // - OSI理论模型
        // - TCP/IP 网络模型
        // 通过Http、FTP、SMTP协议，使用TCP/UDP，拿到对方IP地址，将数据打为bit发送
        // UDP协议：无连接不可靠，会产生数据丢包，常用在视频直播，语音聊天
        // TCP协议：有连接可靠，不保证顺序，常用在文件传输，网页访问
        //      - 三次握手：建立可靠数据连接，保证数据发送不会丢失
        //      - 发送消息过程中，消息都存在ID，确保消息不会重发
        // 四次挥手断开连接：确保通信双方手法消息都已完成
        //      - 客户端发送断开请求，服务端返回收到请求相应，客户端收到确认，发送断开确认
    }

    @Test
    public void udpConnection() throws IOException {
        // 使用UDP发送数据到指定IP地址的指定端口上
        DatagramSocket dp = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的数据：");

        while (true){
            System.out.println("请输入要发送的数据：");
            String msg =  scanner.nextLine();

            dp.send(new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getLocalHost(), 9999));
            // 将数据与ip地址，端口打包
            DatagramPacket pack = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getLocalHost(), 9999);
            // 发送数据
            dp.send(pack);
        }
    }

    @Test
    public void udpReceive() throws IOException {
        DatagramSocket dp = new DatagramSocket(9999);
        byte[] data = new byte[1024 * 64];
        DatagramPacket pack = new DatagramPacket(data, data.length);

        // 增加持续接收消息
        while(true){
            dp.receive(pack);
            // 获取数据的实际长度
            int length = pack.getLength();
            String str = new String(data,0,length);
            System.out.println("收到"+pack.getSocketAddress()+"发送的数据" + str);
        }

    }

    /**
     * tcp中，需要先建立通信
     * */
    @Test
    public void tcpConnection(){
        // 使用Socket管道创建客户端

        // 从通道中得到字节输出流
    }

    @Test
    public void tcpReceive(){

    }
}
