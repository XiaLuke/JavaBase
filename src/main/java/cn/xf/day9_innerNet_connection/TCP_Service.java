package cn.xf.day9_innerNet_connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class TCP_Service {
    // 4. 定义集合存储客户端管道信息，一个服务端只需要一个
    public static final Map<Socket,String > globalMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("服务端启动");
        try {
            // 1.注册端口
            ServerSocket serverSocket = new ServerSocket(5123);
            // 2.主线程监听管道，将监听到的客户端信息交给子线程处理
            while(true) {
                System.out.println("等待客户端连接...");
                Socket accept = serverSocket.accept();
                System.out.println("客户端连接成功");
                // 3.创建子线程，将客户端信息交给子线程处理；5.接收登录消息/群聊消息
                new TCP_Channel(accept).run();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
