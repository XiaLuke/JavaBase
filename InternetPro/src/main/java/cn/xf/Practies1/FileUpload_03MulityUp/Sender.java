package cn.xf.Practies1.FileUpload_03MulityUp;

import java.io.*;
import java.net.Socket;

// 本地发送数据到服务器，服务器接搜到数据后进行下载到本地
// 本地IO & 网络IO 的结合
// 使用多线程持续上传文件
public class Sender {
    // 将本地文件上传到服务器，接收服务器反馈

    private static final String FILEPATH = "";

    public static void main(String[] args) throws IOException {
        // 创建Socket对象，链接服务器
        Socket socket = new Socket("127.0.0.1", 7212);
        // 读取文件，上传到服务器
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(FILEPATH));


        // 一个字节一个字节的传输
        OutputStream stream = socket.getOutputStream();
        // 加工一次，提高传输效率
        BufferedOutputStream bos = new BufferedOutputStream(stream);
        byte[] data = new byte[1024];
        // 文件总长度
        int len;
        // 上传的文件读取完毕
        while ((len = inputStream.read(data)) != -1) {
            bos.write(data, 0, len);
        }

        // 写出结束标记
        socket.shutdownOutput();

        // 接收反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = br.readLine();
        System.out.println(msg);

        // 释放资源
        socket.close();
    }


}
