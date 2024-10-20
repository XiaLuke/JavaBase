package cn.xf.day8_inter_connection;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TCP_Channel_Thread extends Thread {
    private Socket socket;

    public TCP_Channel_Thread(Socket target) {
        this.socket = target;
    }

    // 使用tcp进行对话模式
    /*@Override
    public void run() {
        try {
            // 获取客户端发送的信息
            InputStream inputStream = socket.getInputStream();
            // 将字节输入转为特殊数据输入流
            DataInputStream dis = new DataInputStream(inputStream);
            while(true){
                System.out.println("线程名称："+Thread.currentThread().getName());
                System.out.println("线程id："+Thread.currentThread().getId());
                System.out.println("客户端发送的数据：");
                System.out.println(dis.readUTF());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    // 模拟B/S架构，服务器放回网页，B/S架构不需要客户端
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            PrintStream printStream = new PrintStream(inputStream.toString());

            printStream.println("HTTP/1.1 200 OK");
            printStream.println("Content-Type:text/html;charset=utf-8");
            printStream.println();
            printStream.println("<html>");
            printStream.println("<body>");
            printStream.println("<h1>欢迎使用</h1>");
            printStream.println("</body>");
            printStream.println("</html>");
            printStream.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
