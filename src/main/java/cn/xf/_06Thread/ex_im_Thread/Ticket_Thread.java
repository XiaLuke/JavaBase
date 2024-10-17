package cn.xf._06Thread.ex_im_Thread;

public class Ticket_Thread extends Thread {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("窗口1");
        Ticket ticket2 = new Ticket("窗口2");
        Ticket ticket3 = new Ticket("窗口3");

        ticket1.start();
        ticket2.start();
        ticket3.start();
    }
}

class Ticket extends Thread {
    static int ticket = 10;//数量设置为静态资源，让对象之间进行共享

    //获取窗口的名字
    public Ticket(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println("在" + this.getName() + "获取到" + ticket-- + "票");
        }
    }
}