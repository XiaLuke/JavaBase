package cn.xf.Total.service;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    // 存储用户信息（用户名 -> 密码）
    private static final Map<String, String> userDatabase = new HashMap<>();
    // 存储所有客户端的输出流
    private static final List<PrintWriter> clientWriters = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动...");
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            Socket socket = serverSocket.accept();
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);

                out.println("欢迎来到聊天室！");
                out.println("输入 '1' 登录, 输入 '2' 注册:");

                boolean loggedIn = false;
                String username = null;

                while (!loggedIn) {
                    String option = in.readLine();
                    switch (option) {
                        case "1": // 登录
                            out.println("请输入用户名:");
                            username = in.readLine();
                            out.println("请输入密码:");
                            String password = in.readLine();

                            if (userDatabase.containsKey(username)) {
                                if (userDatabase.get(username).equals(password)) {
                                    out.println("登录成功！");
                                    loggedIn = true;
                                } else {
                                    out.println("密码错误！");
                                }
                            } else {
                                out.println("用户名不存在！");
                            }
                            break;

                        case "2": // 注册
                            out.println("请输入新用户名:");
                            username = in.readLine();
                            if (userDatabase.containsKey(username)) {
                                out.println("用户名已存在！");
                            } else {
                                out.println("请输入新密码:");
                                String newPassword = in.readLine();
                                userDatabase.put(username, newPassword);
                                out.println("注册成功，请重新登录！");
                            }
                            break;

                        default:
                            out.println("无效选项，请输入 '1' 或 '2':");
                    }
                }

                // 登录成功后，加入群聊
                out.println("欢迎 " + username + "！你现在可以发送消息了。输入 'exit' 退出聊天室。");
                broadcast("用户 " + username + " 加入了聊天室！");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        out.println("您已退出聊天室！");
                        break;
                    }
                    broadcast(username + ": " + message);
                }

                broadcast("用户 " + username + " 离开了聊天室！");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) clientWriters.remove(out);
                    if (socket != null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}
