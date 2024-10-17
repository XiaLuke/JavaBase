package cn.xf._05File.serializa;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        * 1.不实现serializable接口时.Exception in thread "main" java.io.NotSerializableException: _03File.serializa.Person
        * 2.
        * */
        write();

//        read();
    }
    public static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream field = new ObjectInputStream(new FileInputStream(new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\TestCopy.txt")));
        Person o =(Person)(field.readObject());
        System.out.println(o);
        field.close();
    }
    public static void write() throws IOException, ClassNotFoundException{
        Person haha = new Person("haha", 12);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\TestCopy.txt")));
        outputStream.writeObject(haha);
        outputStream.close();
    }
}
