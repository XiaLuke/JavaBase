package cn.xf.day9_innerNet_connection;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCP_Channel_Reader implements Runnable {
    private Socket socket;
    private DataInputStream dis;
    private TCP_Signin_Window parent;

    public TCP_Channel_Reader(Socket socket, TCP_Signin_Window parent) {
        this.socket = socket;
        this.parent = parent;
    }

    // 完成登录，请求到了socket管道进入了解界面后
    // 一个客户端存在两个线程，一个用来接收消息，一个用来发送消息
    // 独立线程负责读取客户端socket从服务端收到的在线人数更新数据和群聊数据
    // 收到信息，判断消息类型，判断在线人数更新消息还是群聊消息，分开处理
    public TCP_Channel_Reader() {

    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
                int type = dis.readInt();
                switch (type) {
                    case 1:
                        // 服务端发来的在线人数
                        updateOnlineUserInfo();
                        break;
                    case 2:
                        // 群聊消息
                        break;
                    case 3:
                        break;
                }
            }
        } catch (Exception e) {


        }
    }

    // 更新客户端在线用户列表
    private void updateOnlineUserInfo() throws IOException {
        // 获取在线用户数量
        int count = dis.readInt();
        String[] userNames = new String[count];
        // 循环控制读取多少个用户信息
        for (int i = 0; i < count; i++) {
            String name = dis.readUTF();
            // 将读取到的用户名方法集合中
            userNames[i] = name;
        }
        // 将信息交给窗口
        parent.refreshOnlineUser(userNames);
    }
}
