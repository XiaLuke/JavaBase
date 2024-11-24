package cn.xf.Practies1.MSMR;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// 多发多收
public class MSender {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7676);

        // 获取输出流
        OutputStream os = socket.getOutputStream();
        // 从 Scanner 中获取数据
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入：");
            String msg = sc.nextLine();
            if("exit".equals(msg)){
                break;
            }
            os.write(msg.getBytes());
        }


        // 关闭资源
        socket.close();
    }
}
