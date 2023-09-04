package cn.xf.thread.runnable;

public class RunnableTest {
    public static void main(String[] args) {
        RunnableDemo thread1 = new RunnableDemo("thread1");
        thread1.start();

        RunnableDemo thread2 = new RunnableDemo("thread2");
        thread2.start();
    }
}

class RunnableDemo implements Runnable{

    private Thread thread;
    private String threadName;

    public RunnableDemo(String name) {
        this.threadName = name;
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println("当前调用线程为："+threadName+","+i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        if(thread==null) {
            thread  = new Thread(this,threadName);
            thread.start();
        }
    }
}