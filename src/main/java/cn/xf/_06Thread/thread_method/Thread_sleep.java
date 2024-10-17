package cn.xf._06Thread.thread_method;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Thread_sleep {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        while (true){
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
