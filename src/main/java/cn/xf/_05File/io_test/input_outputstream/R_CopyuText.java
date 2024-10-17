package cn.xf._05File.io_test.input_outputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 利用缓冲流复制非文本文件
 * */
public class R_CopyuText {
    public static void main(String[] args) throws IOException {
        //源文件
        File f1 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\diff.png");
        //目标文件
        File f2 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\copy.png");
        //将文件读取到管道中
        FileInputStream inputStream = new FileInputStream(f1);
        //将管道中的流输出到文件中
        FileOutputStream outputStream = new FileOutputStream(f2);

        //*复制文件
        //方式1：读一个字节输出一个字节,耗时：2175 3852
        /*
        int read = inputStream.read();
        while (read!=-1){
            outputStream.write(read);
            read = inputStream.read();
        }*/

        //方式2：读取一定长度后在输出
        byte[] bytes = new byte[1024 * 8];
        int read = inputStream.read(bytes);
        while (read != -1) {
            //1.直接输出
            //outputStream.write(read);
            //2.指定位置输出
            outputStream.write(bytes, 0, read);
            read = inputStream.read(bytes);
        }

        //关闭输入输出流（先开后关）
        outputStream.close();
        inputStream.close();
    }
}
