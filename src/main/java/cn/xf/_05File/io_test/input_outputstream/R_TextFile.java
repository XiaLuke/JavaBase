package cn.xf._05File.io_test.input_outputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class R_TextFile {
    public static void main(String[] args) throws IOException {
        //功能：利用字节流将文件中内容读到程序中来：
        // 1.有一个源文件：
        File f = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\Test.txt");
        // 2.将一个字节流这个管 怼  到 源文件上：
        FileInputStream fis = new FileInputStream(f);
        // 3.开始读取动作
        /*
        *
        * 细节1：
        *   文件是utf-8进行存储的，所以英文字符 底层实际占用1个字节        但是中文字符，底层实际占用3个字节。

        * 细节2：
        *   如果文件是文本文件，那么就不要使用字节流读取了，建议使用字符流。

        * 细节3：
        *   read()读取一个字节，但是你有没有发现返回值是 int类型，而不是byte类型？
        *   read方法底层做了处理，让返回的数据都是“正数”
        *   就是为了避免如果字节返回的是-1的话，那到底是读入的字节，还是到文件结尾呢。
        * */
        int n = fis.read();
        while (n != -1) {
            System.out.println(n);
            n = fis.read();
        }
        //4.关闭流：
        fis.close();
    }
}
