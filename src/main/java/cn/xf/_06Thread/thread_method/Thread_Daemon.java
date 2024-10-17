package cn.xf._06Thread.thread_method;

public class Thread_Daemon extends Thread{
    @Override
    public void run() {
        for(int i=1;i<100;i++){
            System.out.println("Thread\t"+i);
        }
    }
}

class Test1{
    public static void main(String[] args) {
        Thread_Daemon daemon = new Thread_Daemon();
        daemon.setDaemon(true);
        daemon.start();

        for(int i=0;i<10;i++){
            System.out.println("主线程\t"+i);
        }
    }
}
