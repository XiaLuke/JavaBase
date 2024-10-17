package cn.xf._05File.io_test.bufferinput_outputstream;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        //確定源文件
        File f1 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\diff.png");
        //确定输出文件
        File f2 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\copy2.png");
        //按照字节输入流处理
        FileInputStream inputStream = new FileInputStream(f1);
        //按照字节输出流处理
        FileOutputStream outputStream = new FileOutputStream(f2);
        //使用缓冲流提高效率
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        byte[] bytes = new byte[1024];
        int read = bufferedInputStream.read(bytes);
        while (read!=-1){
            bufferedOutputStream.write(bytes,0,read);
            read = bufferedInputStream.read(bytes);
        }

        //先开后关，按照最高级别关闭
        bufferedOutputStream.close();
        bufferedInputStream.close();

    }
}
