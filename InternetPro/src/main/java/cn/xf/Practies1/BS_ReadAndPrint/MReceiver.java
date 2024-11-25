package cn.xf.Practies1.BS_ReadAndPrint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 从浏览器中发送访问地址，在服务端接收
public class MReceiver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7676);

        Socket accept = ss.accept();
        // 获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));

        // 非阻塞方式获取数据
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }
        accept.close();
        ss.close();
    }
}
