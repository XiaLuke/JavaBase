package cn.xf.Practies1.FileUpload_04ThreadPool;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable implements Runnable {

    Socket socket;
    String FILEOUTPATH;

    public MyRunnable(Socket socket, String filePath) {
        this.socket = socket;
        this.FILEOUTPATH = filePath;
    }

    @Override
    public void run() {
        try {
            // 处理文件名重复：使用UUID | 遍历当前目录，获取当前文件名，判断是否存在
            String randName = UUID.randomUUID().toString().replaceAll("_", "");

            // 从链接中读取数据、保存到本地中
            BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
            // 获取输出流，保存到本地
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILEOUTPATH + randName));


            int len;
            byte[] bytes = new byte[1024];
            while ((len = bi.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            // 文件上传完毕反馈数据
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("文件上传完毕");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
