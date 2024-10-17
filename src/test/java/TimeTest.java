package java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiafan
 * @version 1.0
 * @date 2021/12/22 13:20
 */
public class TimeTest {
    @Test
    public void func1() throws InterruptedException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");

        int beforeDay = 7;
        for (int i = beforeDay ; i > 0 ; i--) {
            Date tempDate = date;
            calendar.setTime(tempDate);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            tempDate = calendar.getTime();
            Thread.sleep(1500);
            System.out.println("里面获取时间:"+sdf.format(tempDate));
        }
    }
    @Test
    public void func2() throws InterruptedException{
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");

        int beforeDay = 7;
        for (int i = 0 ; i < beforeDay ; i++) {
            Date tempDate = date;
            calendar.setTime(tempDate);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            tempDate = calendar.getTime();
            Thread.sleep(1500);
            System.out.println("里面获取时间:"+sdf.format(tempDate));
        }
    }
}
