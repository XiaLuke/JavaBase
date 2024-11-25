package cn.xf.Practies1.FileUpload_04ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 持续接收文件
public class Receiver {
    // 接收客户端上传文件，上传完毕后给出反馈
    private static final String FILEOUTPATH = "";

    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                3, // 核心线程数
                9, // 线程池总大小
                60, TimeUnit.SECONDS, // 线程空闲时间与单位
                new ArrayBlockingQueue<>(2), // 队列
                Executors.defaultThreadFactory(), // 线程工厂
                new ThreadPoolExecutor.AbortPolicy()); // 阻塞队列
        ServerSocket serviceSocket = new ServerSocket(7212);

        // 等待客户端链接
        while (true) {
            Socket sock = serviceSocket.accept();

            // 若第一个文件还未上传完毕，第二个线程上传了其他文件（无法连接）
            // 修改为：一个用户一个线程
//            new Thread(new MyRunnable(sock, FILEOUTPATH)).start();

            // 使用线程池、减少开销
            tpe.submit(new MyRunnable(sock,FILEOUTPATH));
        }
    }
}
