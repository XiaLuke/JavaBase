package cn.xf.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<20;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }

    public static void main(String[] args) {
        CallableTest test = new CallableTest();
        FutureTask<Integer> futureTask = new FutureTask<>(test);
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "变量值为" + i);
            if (i == 4) {
                new Thread(futureTask, "返回线程为").start();
            }
        }
        try {
            System.out.println("子线程返回值：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

