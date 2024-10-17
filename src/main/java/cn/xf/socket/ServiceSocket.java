package cn.xf.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServiceSocket extends Thread {
    private ServerSocket serverSocket;

    public ServiceSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while (true) {
            try {
                // 获取远程连接端口号
                System.out.println("远程连接地址为："+serverSocket.getLocalPort()+"...");
                // 获取接收对象--如果没有对象连接则会超时
                Socket socket = serverSocket.accept();
                // 获取连接地址
                System.out.println("远程连接地址为："+socket.getRemoteSocketAddress());
                // 获取数据输入流
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                // 读取数据
                System.out.println(inputStream.readUTF());
                // 返回数据
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("谢谢连接："+socket.getLocalSocketAddress());
                // 关闭流
                socket.close();
            }catch(SocketTimeoutException e) {
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args)
    {
//        int port = Integer.parseInt(args[0]);
        int port = 6066;
        try
        {
            Thread t = new ServiceSocket(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
