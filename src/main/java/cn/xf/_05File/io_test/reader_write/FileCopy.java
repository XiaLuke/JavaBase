package cn.xf._05File.io_test.reader_write;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //1.有一个源文件
        File f1 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\demo.txt");
        // 2.有一个目标文件：
        File f2 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\Test.txt");
        // 3.搞一个输入的管 怼到源文件上：
        FileReader fr = new FileReader(f1);
        // 4.搞一个输出的管，怼到目标文件上：
        FileWriter fw = new FileWriter(f2);
        // 5.开始动作：
        // 方式1：一个字符一个字符的复制：
        /*int n = fr.read();
        while (n != -1) {
            fw.write(n);
            n = fr.read();
        }*/
        // 方式2：利用缓冲字符数组：
        /*char[] ch = new char[5];
        int len = fr.read(ch);
        while (len != -1) {
            fw.write(ch, 0, len);//将缓冲数组中有效长度写出
            len = fr.read(ch);
        }*/
        // 方式3：利用缓冲字符数组，将数组转为String写出。
        char[] ch = new char[5];
        int len = fr.read(ch);
        while (len != -1) {//当读到最后一个
            String s = new String(ch, 0, len);
            fw.write(s);
            len = fr.read(ch);
        }
        // 6.关闭流：(关闭流的时候，倒着关闭，后用先关)
        fw.close();
        fr.close();
    }
}