package cn.xf.Practies1.FileUpload_02NameRepeatable;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Receiver {
    // 接收客户端上传文件，上传完毕后给出反馈
    private static final String FILEOUTPATH = "";

    public static void main(String[] args) throws IOException {
        ServerSocket serviceSocket = new ServerSocket(7212);

        // 等待客户端链接
        Socket sock = serviceSocket.accept();

        // 处理文件名重复：使用UUID | 遍历当前目录，获取当前文件名，判断是否存在
        String randName = UUID.randomUUID().toString().replaceAll("_", "");

        // 从链接中读取数据、保存到本地中
        BufferedInputStream bi = new BufferedInputStream(sock.getInputStream());
        // 获取输出流，保存到本地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILEOUTPATH + randName));


        int len;
        byte[] bytes = new byte[1024];
        while ((len = bi.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 文件上传完毕反馈数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        bw.write("文件上传完毕");
        bw.newLine();
        bw.flush();


        sock.close();
        serviceSocket.close();
    }
}
