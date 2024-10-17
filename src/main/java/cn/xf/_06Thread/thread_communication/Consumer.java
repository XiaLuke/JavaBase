package cn.xf._06Thread.thread_communication;

public class Consumer extends Thread{
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    //方式1
    /*@Override
    public void run() {
        for (int i = 1; i <10 ; i++) {
            System.out.println("消费者消费了：" + product.getBrand() + "---" + product.getName());
        }
    }*/

    //方式2--增加同步锁
    /*@Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            synchronized (product) {
                System.out.println("消费者消费了：" + product.getBrand() + "---" + product.getName());
            }
        }
    }*/

    //方式3
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            product.consumption();
        }
    }
}
