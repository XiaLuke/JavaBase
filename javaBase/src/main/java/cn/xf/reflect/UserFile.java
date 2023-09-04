package cn.xf.reflect;

import java.io.FileReader;
import java.util.Properties;

public class UserFile {
    public static void main(String[] args) throws Exception{
        String path = Thread.currentThread().getContextClassLoader().getResource("src/sdfasdf.properties").getPath();
        FileReader fileReader = new FileReader(path);

        Properties properties = new Properties();
        properties.load(fileReader);
        fileReader.close();

        String className = properties.getProperty("className");

        System.out.println(className);

    }
}
