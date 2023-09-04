package cn.xf.thread.deadLock;

public class DeadLock {


    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread1 thread1 = new Thread1(o1, o2);
        Thread2 thread2 = new Thread2(o1, o2);


    }
}

class Thread1 extends Thread {
    Object o1;
    Object o2;

    public Thread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    public void run(){
        synchronized (o1){
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }
    }
}

class Thread2 extends Thread {
    Object o1;
    Object o2;
    public Thread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void run(){
        synchronized (o2){
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }
    }
}
