package cn.xf._06Thread.thread_security;

public class Thread_syn_method {
    public static void main(String[] args) {
        synchronized_3 ticket1 = new synchronized_3("窗口1");
        synchronized_3 ticket2 = new synchronized_3("窗口2");
        synchronized_3 ticket3 = new synchronized_3("窗口3");

        ticket1.start();
        ticket2.start();
        ticket3.start();
    }
}

class synchronized_3 extends Thread {
    static int ticket = 10;//数量设置为静态资源，让对象之间进行共享

    //获取窗口的名字
    public synchronized_3(String name) {
        super(name);
    }

    @Override
    public void run() {
        getticket();
    }

    /*
    * 不加static修饰依然会存在 超卖情况
    * 加入static后，不能再使用this指代当前对象（static中不支持this）
    * */
    private static synchronized void getticket() {
        while (ticket > 0) {
            System.out.println("在" + Thread.currentThread().getName() + "获取到" + ticket-- + "票");
        }
    }
}