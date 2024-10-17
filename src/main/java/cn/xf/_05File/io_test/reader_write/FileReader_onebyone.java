package cn.xf._05File.io_test.reader_write;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_onebyone {
    public static void main(String[] args) throws IOException {
        //文件--》程序：
        // 1.有一个文件：----》创建一个File类的对象
        File f = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\demo.txt");
        // 2.利用FileReader这个流，这个“管”怼到源文件上去   ---》创建一个FileReader的流的对象
        FileReader fr = new FileReader(f);
        // 3.进行操作“吸”的动作  ---》读取动作
        //下面的代码我们验证了：如果到了文件的结尾处，那么读取的内容为-1
        /*int n1 = fr.read();
        int n2 = fr.read();
        int n3 = fr.read();
        int n4 = fr.read();
        int n5 = fr.read();
        int n6 = fr.read();
        int n7 = fr.read();
        int n8 = fr.read();
        int n9 = fr.read();
        int n10 = fr.read();
        int n11 = fr.read();
        int n12 = fr.read();
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
         System.out.println(n6);
         System.out.println(n7);
         System.out.println(n8);
         System.out.println(n9);
         System.out.println(n10);
         System.out.println(n11);
         System.out.println(n12);*/
        // 方式1：
        /*int n = fr.read();
        while (n != -1) {
            System.out.println(n);
            n = fr.read();
        }*/
        //方式2：
        int n;
        while ((n = fr.read()) != -1) {
            System.out.println((char) n);
        }
        // 4.“管”不用了，就要关闭  ---》关闭流
        // 流，数据库，网络资源，靠jvm本身没有办法帮我们关闭，此时必须程序员手动关闭：
        fr.close();
    }
}
