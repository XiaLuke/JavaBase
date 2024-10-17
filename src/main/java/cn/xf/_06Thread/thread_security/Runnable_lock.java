package cn.xf._06Thread.thread_security;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Description: 线程安全
 * */
public class Runnable_lock {
    public static void main(String[] args) {
        synchronized_lock ticket1 = new synchronized_lock();
        Thread thread = new Thread(ticket1, "窗口1");
        Thread thread1 = new Thread(ticket1, "窗口2");
        Thread thread2 = new Thread(ticket1, "窗口3");

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class synchronized_lock implements Runnable {
    int ticket = 10;

    //使用多态获取锁  接口==多态，拓展性强
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            lock.lock();
            try {
                if (ticket > 0) {
                    System.out.println("在" + Thread.currentThread().getName() + "买的" + ticket-- + "票");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}