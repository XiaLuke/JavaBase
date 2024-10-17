package cn.xf._05File.io_test.istreamreader_ostreamwrite;

import java.io.*;

/*
 * 字节流转化为字符流
 * */
public class Byte2Char {
    public static void main(String[] args) throws IOException {
        //获取文件
        File file = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\Test.txt");
        //确定目标文件
        File file2 = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\TestCopy.txt");

        //输入方向
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        //输出方向
        FileOutputStream outputStream = new FileOutputStream(file2);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);


        //定义读取长度
        char[] chars = new char[20];
        int read = inputStreamReader.read(chars);
        while (read != -1) {
            System.out.println(new String(chars, 0, read));
            outputStreamWriter.write(chars,0,read);
            read = inputStreamReader.read(chars);
        }

        outputStreamWriter.close();
        inputStreamReader.close();
    }

}
