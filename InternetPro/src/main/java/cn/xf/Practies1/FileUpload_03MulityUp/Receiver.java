package cn.xf.Practies1.FileUpload_03MulityUp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 持续接收文件
public class Receiver {
    // 接收客户端上传文件，上传完毕后给出反馈
    private static final String FILEOUTPATH = "";

    public static void main(String[] args) throws IOException {
        ServerSocket serviceSocket = new ServerSocket(7212);

        // 等待客户端链接
        while (true) {
            Socket sock = serviceSocket.accept();

            // 若第一个文件还未上传完毕，第二个线程上传了其他文件（无法连接）
            // 修改为：一个用户一个线程
            new Thread(new MyRunnable(sock, FILEOUTPATH)).start();

        }
    }
}
