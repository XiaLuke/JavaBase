package cn.xf.Total.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

// 服务端，做消息转发操作，登录操作
public class Service {
    private static final Set<Socket> clientSockets = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端已启动，等待连接....");

        while (true) {
            Socket socket = serverSocket.accept();
            synchronized (socket) {
                clientSockets.add(socket); // 添加到客户端集合
            }
            new Thread(() -> handleClient(socket)).start();

        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String msg;
            while ((msg = reader.readLine()) != null) {
                System.out.println("收到消息: " + msg);
                // 将消息广播给其他客户端
                broadcastMessage(msg, clientSocket);
            }
        } catch (IOException e) {
            System.out.println("客户端断开连接: " + clientSocket.getInetAddress().getHostAddress());
        } finally {
            synchronized (clientSockets) {
                clientSockets.remove(clientSocket); // 移除断开的客户端
            }
            try {
                clientSocket.close();
            } catch (IOException ignored) {
            }
        }
    }

    private static void broadcastMessage(String msg, Socket socket) {
        synchronized (socket) {
            for (Socket item : clientSockets) {
                if(socket != item){
                    try {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(item.getOutputStream()));
                        writer.write(msg); // 写入消息
                        writer.newLine(); // 添加换行符
                        writer.flush(); // 刷新输出流
                    } catch (IOException e) {
                        System.out.println("发送消息失败: " + e.getMessage());
                    }
                }
            }
        }
    }
}
