package cn.xf.Total.client;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//
public class Client {
    private static final File file = new File("E:\\File\\JavaProject\\XF\\JavaBase\\InternetPro\\src\\main\\java\\cn\\xf\\Total\\account.txt");

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        System.out.println("服务器连接成功");

        while (true) {
            System.out.println("=== Welcome to onLine chain ===");
            System.out.println("1 登录");
            System.out.println("2 注册");
            System.out.println("请输入选择");
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();
            switch (choose) {
                case "1" -> Login(socket);
                case "2" -> Registry(socket);
                default -> System.out.println("没有该选项");
            }
            sc.close();
            break;

        }
    }

    private static void Registry(Socket socket) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        // 判断account.txt文件中等号左边的内容是否有与msg相等的内容，已存在用户名时进行提示
        if (!file.exists()) {
            file.createNewFile();
        }
        Scanner fileScanner = new Scanner(file);
        boolean userExit = false;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String name = line.split("=")[0];
            if (name.equals(username)) {
                userExit = true;
                break;
            }
        }
        fileScanner.close();
        if (userExit) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("请输入密码");
            String password = sc.nextLine();
            BufferedWriter nameWrite = new BufferedWriter(new FileWriter(file, true));
            nameWrite.newLine();
            nameWrite.write(username + "=" + password);
            nameWrite.close();
            System.out.println("注册成功");
        }
    }

    private static void Login(Socket socket) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();

        Scanner scanner = new Scanner(file);
        Map<String, String> fileMap = new HashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String key = line.split("=")[0];
            String value = line.split("=")[1];
            fileMap.put(key, value);
        }
        Set<String> keySet = fileMap.keySet();
        if (keySet.contains(username)) {
            System.out.println("请输入密码");
            String pass = sc.nextLine();
            if (!fileMap.get(username).equals(pass)) {
                System.out.println("密码错误");
            }
            System.out.println(username + "登录成功");
            sc.close();
            scanner.close();
            LoginSuccess(socket, username);
        } else {
            System.out.println("用户名不存在");
            sc.close();
            scanner.close();
        }
    }

    private static void LoginSuccess(Socket socket, String username) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        new Thread(() -> {
            try {
                while (true) {
                    String msg = sc.nextLine();
                    if(msg.equals("exit")){
                        break;
                    }
                    writer.write(username + ":" + msg);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                System.out.println("消息发送失败" + e.getMessage());
            }
        }).start();

        // 接收消息
        new Thread(()->{
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String serverMsg;
                while ((serverMsg = reader.readLine()) != null) {
                    System.out.println(serverMsg); // 打印服务端消息
                }
            } catch (IOException e) {
                System.out.println("接收消息失败: " + e.getMessage());
            }
        }).start();
    }
}
