package cn.xf._05File.io_test.data;

import java.io.*;

/*
* 将内存中的数据写入磁盘中
*   如果直接打开文件会发现文件是乱码的，只适用于计算机识别
* */
public class distream_dostream {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\Test.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.write(123);
        dataOutputStream.writeBoolean(false);
        dataOutputStream.writeByte(233);

        dataOutputStream.close();
        read_();
    }

    public static void read_() throws IOException {
        File file = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\Test.txt");
        FileInputStream inputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println(dataInputStream.read());
        System.out.println(dataInputStream.readBoolean());
        System.out.println(dataInputStream.readByte());
        dataInputStream.close();
    }
}
