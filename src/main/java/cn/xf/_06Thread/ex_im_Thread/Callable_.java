package cn.xf._06Thread.ex_im_Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable_ implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(20);
    }
}

class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable_ callable_ = new Callable_();
        FutureTask<Integer> task = new FutureTask<>(callable_);
        Thread thread = new Thread(task);
        thread.start();
        //获取线程的返回值
        System.out.println(task.get());
    }
}

