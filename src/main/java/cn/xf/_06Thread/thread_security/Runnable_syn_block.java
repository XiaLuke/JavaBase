package cn.xf._06Thread.thread_security;


/*
 * @Description: 线程安全
 * */
public class Runnable_syn_block {
    public static void main(String[] args) {
        synchronized_ ticket1 = new synchronized_();
        Thread thread = new Thread(ticket1, "窗口1");
        Thread thread1 = new Thread(ticket1, "窗口2");
        Thread thread2 = new Thread(ticket1, "窗口3");

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class synchronized_ implements Runnable {
    int ticket = 10;

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {

            synchronized (this) {// 将存在安全问题的代码锁住，但是会降低效率，this指代当前锁
                if (ticket > 0) {
                    System.out.println("在" + Thread.currentThread().getName() + "买的" + ticket-- + "票");
                }
            }
        }
    }
}