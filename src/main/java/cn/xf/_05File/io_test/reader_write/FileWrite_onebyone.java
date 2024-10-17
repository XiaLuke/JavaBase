package cn.xf._05File.io_test.reader_write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite_onebyone {
    public static void main(String[] args) throws IOException {
        //1.有个目标文件：
        File f = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\demo.txt");
        // 2.FileWriter管怼到文件上去：
        FileWriter fw = new FileWriter(f);

        // 3.开始动作：输出动作：
        // 一个字符一个字符的往外输出：
        String str = "hello你好";
        for (int i = 0; i < str.length(); i++) {
            fw.write(str.charAt(i));
        }
        // 4.关闭流：
        fw.close();
    }
}
