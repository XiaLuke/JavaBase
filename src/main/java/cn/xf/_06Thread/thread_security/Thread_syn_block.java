package cn.xf._06Thread.thread_security;

public class Thread_syn_block {
    public static void main(String[] args) {
        synchronized_1 ticket1 = new synchronized_1("窗口1");
        synchronized_1 ticket2 = new synchronized_1("窗口2");
        synchronized_1 ticket3 = new synchronized_1("窗口3");

        ticket1.start();
        ticket2.start();
        ticket3.start();
    }
}

class synchronized_1 extends Thread {
    static int ticket = 10;//数量设置为静态资源，让对象之间进行共享

    //获取窗口的名字
    public synchronized_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        /*
         * 这里不能再使用this来作为锁，锁必须多个线程共用一个锁
         *
         * 锁不能为基本数据类型，必须是引用数据类型
         *
         * 在引用锁时，不能改变同步监视器对象的引用，如果是引用数据类型，需要使用final进行修饰，
         * 但锁的也只是地址值，其中对象属性依然可以改变
         * */
        synchronized(synchronized_1.class){
            while (ticket > 0) {
                System.out.println("在" + this.getName() + "获取到" + ticket-- + "票");
            }
        }

    }
}