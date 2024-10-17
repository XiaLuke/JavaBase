package cn.xf._05File.io_test.systofile;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        //获取控制台输入数据----字节流
        InputStream is = System.in;
        //将数据转为字符流
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        //对字符流增强
        BufferedReader reader = new BufferedReader(inputStreamReader);

        //将字符流输出
        //目标文件
        File file = new File("D:\\WorkFile\\IdeaProject\\SchoolStudy\\JavaBasis\\Test.txt");
        FileWriter writer = new FileWriter(file);
        BufferedWriter writer1 = new BufferedWriter(writer);

        //开始写入
        String s = reader.readLine();
        while (!s.equals("exit")) {
            writer1.write(s);
            writer1.newLine();//文件中换行
            s = reader.readLine();
        }
        //4.关闭流：
        writer1.close();
        reader.close();
    }
}
