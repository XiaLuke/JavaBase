package cn.xf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
public class DosUtil {
    public static void main(String[] args) {
        // Java调用 dos命令
        String cmd = "sc query MySQL";
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"GBK");
            BufferedReader br = new BufferedReader(isr);
            String content = br.readLine();
            while (content != null) {
                System.out.println(content);
                
                content = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}