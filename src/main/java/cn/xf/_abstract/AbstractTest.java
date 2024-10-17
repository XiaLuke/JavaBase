package cn.xf._abstract;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractTest {
    public static void main(String[] args) {
        String keyWord = "chrome.exe";

        Runtime runtime = Runtime.getRuntime();

        try {
            Process process = runtime.exec("cmd /c Tasklist");

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ((s = in.readLine()) != null) {
                s = s.toLowerCase();
                if (s.startsWith(keyWord)) {
                    System.out.println("==========>"+keyWord);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
