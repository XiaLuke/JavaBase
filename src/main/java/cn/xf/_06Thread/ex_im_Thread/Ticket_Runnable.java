package cn.xf._06Thread.ex_im_Thread;

public class Ticket_Runnable {
    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();
        Thread thread = new Thread(ticket1, "窗口1");
        Thread thread1 = new Thread(ticket1, "窗口2");
        Thread thread2 = new Thread(ticket1, "窗口3");

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Ticket1 implements Runnable{
    int ticket = 10;
    @Override
    public void run() {
        for(int i=1;i<100;i++){
            if(ticket>0){
                System.out.println("在"+Thread.currentThread().getName()+"买的"+ticket--+"票");
            }
        }
    }
}
