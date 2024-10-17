package cn.xf._06Thread.thread_method;

public class Test {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02();

        //设置优先级
        thread01.setPriority(1);//级别优先级低
        thread02.setPriority(5);//级别优先级高

        thread01.start();
        thread02.start();
    }
}

class Thread01 extends Thread{
    @Override
    public void run() {
        for (int i=1;i<10;i++){
            System.out.println("Thread1\t"+i);
        }
    }
}

class Thread02 extends Thread{
    @Override
    public void run() {
        for (int i=1;i<10;i++){
            System.out.println("Thread2\t"+i);
        }
    }
}