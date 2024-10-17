package cn.xf._05File.io_test.input_outputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class R_uTextFile {
    public static void main(String[] args) throws IOException {
        //功能：利用字节流将文件中内容读到程序中来：
        // 1.有一个源文件：
        File f = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\diff.png");
        // 2.将一个字节流这个管怼到源文件上：
        FileInputStream fis = new FileInputStream(f);
        // 3.开始读取动作
        int count = 0;//定义一个计数器，用来计读入的字节的个数
        int n = fis.read();
        while (n != -1) {
            count++;
            System.out.println(n);
            n = fis.read();
        }
        System.out.println("count=" + count);
        // 4.关闭流：
        fis.close();
    }
}
