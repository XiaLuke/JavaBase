package cn.xf._05File.io_test.input_outputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
* 使用缓冲数组读取文件
* */
public class R_uTextFile_byte {
    public static void main(String[] args) throws IOException {
        //功能：利用字节流将文件中内容读到程序中来：
        // 1.有一个源文件：
        File f = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\diff.png");
        // 2.将一个字节流这个管 怼  到 源文件上：
        FileInputStream fis = new FileInputStream(f);
        // 3.开始读取动作
        // 利用缓冲数组：（快递员的小车）
        byte[] b = new byte[1024 * 5];
        int len = fis.read(b);//len指的就是读取的数组中的有效长度
        while (len != -1) {
            System.out.println(len);
            for (int i = 0; i < len; i++) {
                System.out.println(b[i]);
            }
            len = fis.read(b);
        }
        // 4.关闭流：
        fis.close();
    }
}
