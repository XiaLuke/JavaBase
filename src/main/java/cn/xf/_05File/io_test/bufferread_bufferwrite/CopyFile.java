package cn.xf._05File.io_test.bufferread_bufferwrite;

import java.io.*;

/*
* 缓冲字符流
* */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        //確定源文件
        File f1 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\Test.txt");
        //确定输出文件
        File f2 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\TestCopy.txt");
        //按照字符输入流处理
        FileReader reader = new FileReader(f1);
        //按照字符输出流处理
        FileWriter writer = new FileWriter(f2);
        //使用缓冲流提高效率
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        //复制文件
        char[] chars = new char[56];//自定义读取长度
        int read = reader.read(chars);
        while(read!=-1){//当还没有读取到最后一位时
            bufferedWriter.write(chars,0,read);//每次写自定义长度，从零位开始，直到结束
            read = reader.read(chars);
        }

        //关闭流
        bufferedWriter.close();
        bufferedReader.close();

    }
}
