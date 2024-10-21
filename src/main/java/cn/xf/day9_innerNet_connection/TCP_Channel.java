package cn.xf.day9_innerNet_connection;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class TCP_Channel implements Runnable{
    Socket socket = null;
    public TCP_Channel(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            // 5.接收登录消息/群聊消息
            DataInputStream stream = new DataInputStream(socket.getInputStream());
            int type = stream.readInt();
            switch (type) {
                case 1:
                    // 客户端发的登录消息，接收昵称数据，更新在线客户端的人数列表
                    String nickName = stream.readUTF();
                    TCP_Service.globalMap.put(socket,nickName); // 将客户端信息放入map
                    refreshOnlineUser();// 更新客户端在线列表
                    break;
                case 2:
                    // 客户端发送的群聊消息，接收群聊消息，转发给所有客户端
                    String msg = stream.readUTF();
                    sendMsg(msg);
                    break;
                case 3:
                    // 客户端发送的群聊消息，接收私聊内容，转发给指定客户端
                    break;
                default:
                    break;
            }
        }catch (Exception e) {
            System.out.println("客户端退出"+socket.getInetAddress().getHostAddress());
            TCP_Service.globalMap.remove(socket);
            refreshOnlineUser();
        }
    }

    // 将消息推送给所有人
    private void sendMsg(String msg) {
        StringBuilder sb = new StringBuilder();
        String name = TCP_Service.globalMap.get(socket);
        LocalDateTime dateNoa = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sb.append(name).append(" ").append(dateNoa.format(formatter)).append(" \r\n ").append(msg);
        for (Socket socket : TCP_Service.globalMap.keySet()) {
            try {
                DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
                stream.writeInt(2);
                stream.writeUTF(sb.toString());
            }catch (Exception e) {

            }
        }
    }

    public void refreshOnlineUser() {
        // 获取在线客户端列表
        Collection<String> values = TCP_Service.globalMap.values();
        // 获取列表中名称
        String[] names = values.toArray(new String[0]);
        // 将名称转发给所有socket
        for (Socket socket : TCP_Service.globalMap.keySet()) {
            try {
                // 转为特殊数据流
                DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
                stream.writeInt(1);
                stream.writeInt(names.length); // 告诉客户端，有多少个在线用户
                for (String name : names) {
                    stream.writeUTF(name);
                }
            }catch (Exception e) {

            }
        }
    }
}
