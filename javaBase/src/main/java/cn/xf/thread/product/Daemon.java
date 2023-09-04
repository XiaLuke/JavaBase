package cn.xf.thread.product;

public class Daemon {
    public static void main(String[] args) {
        Thread t = new Thread1();
        t.setDaemon(true);
        t.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+""+(++i));
            try {
                Thread.sleep(20);

            }catch (InterruptedException e){}
        }
    }
}
class Thread1 extends Thread{
    public void run(){
        int i = 0;
        while (true){
            System.out.println(Thread.currentThread().getName()+""+(++i));
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}
