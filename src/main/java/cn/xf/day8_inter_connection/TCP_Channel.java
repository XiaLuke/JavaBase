package cn.xf.day8_inter_connection;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

public class TCP_Channel {
    /**
     * tcp通信模式
     * 在一对一中，使用一个客户端对应一个 服务端 方式，只要绑定了ip地址+端口，客户端发送消息，服务端就能收到
     *
     * 在一对多中给，使用多个客户端对应一个 服务端 方式，服务端只能收到一个客户端的发送的数据
     * 采用多线程的方式：
     * - 主线程 服务端主线程用来 接收客户端连接
     * - 子线程 用来接收不同客户端发送的消息
     *
     * 在可靠通信时，当客户端断开或其他异常原因时，服务端也会关闭
     *
     * B/S原理：
     * - 服务端 收到请求时
     * -   给对应的浏览器管道相应网页数据
     * -   使用字节输出流，返回前端数据；3.服务器要给浏览器返回HTTP协议规定的数据
     *
     * HTTP协议规定：
     * 协议版本 空格 状态码 空格 状态苻  \r\n （HTTP/1.1 200 OK）
     * 请求头 \r\n （Content-Type:text/html;charset=UTF-8）
     * 。。。
     * \r\n
     * 响应正文
     * */
    // tcp客户端
    @Test
    public void tcpConnection() throws Exception{
        // 使用Socket管道创建客户端
        Socket socket = new Socket("127.0.0.1",8080);
        // 从通道中得到字节输出流
        OutputStream outputStream = socket.getOutputStream();
        // 特殊数据流
        DataOutputStream dos = new DataOutputStream(outputStream);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入：");
            String msg = sc.nextLine();
            if("exit".equals(msg)){
                dos.close(); // 关闭输出流
                socket.close(); // 关闭通道
                break;
            }
            dos.writeUTF(msg);
            dos.flush();
        }
        // 关闭管道
        // dos.close()
    }

    /**
     * tcp服务端
     * */
    @Test
    public void tcpReceive() throws Exception{
        System.out.println("服务器已启动");
        // 使用ServerSocket创建服务器
        ServerSocket serverSocket = new ServerSocket(5123);
        // 阻塞式监听客户端；2. 这里会导致只监听一个客户端的消息，若使用循环（while），还是只能监听一个客户端

        /*// 获取输入流
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        // 将字节输入转为特殊数据输入流
        DataInputStream dis = new DataInputStream(inputStream);
        // 读取数据，如何发送数据，这里就要如何读取；
        // dis.readInt();
        // 更新为持续接收客户端信息
        while(true){
            System.out.println(dis.readUTF());
        }*/
        // 3.增加线程池处理B/S架构中客户端请求
        ExecutorService pool = new ThreadPoolExecutor(3,10,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        // 引入多线程，主线程负责客户端连接，子线程负责接收客户端消息
        while(true) {
            // 持续等待客户端连接
            Socket socket = serverSocket.accept();
            // 2.建立子线程，将监听到的客户端连接交给新的线程使用
            // 要想让子线程启动，需要调用start方法
            // new TCP_Channel_Thread(socket).start();
            // 在模拟B/S架构时，每次请求都会建立一个线程，增加资源消耗，可使用线程池方式
            // 3.将客户端管道包装为任务交给线程池，子线程继承Thread或实现Runnable
            pool.execute(new TCP_Channel_Thread(socket));
        }
    }
}
