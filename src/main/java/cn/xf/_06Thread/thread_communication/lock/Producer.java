package cn.xf._06Thread.thread_communication.lock;


public class Producer extends Thread {
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    /*
     * 问题1：
     * 没有加同步锁的情况下：出现的结果-->
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 消费者消费了：老板---null
     * 生产者生产老板----墨水
     * 生产者生产得力----铅笔
     * 生产者生产老板----墨水
     * 生产者生产得力----铅笔
     * 生产者生产老板----墨水
     * 生产者生产得力----铅笔
     * 生产者生产老板----墨水
     * 生产者生产得力----铅笔
     * 生产者生产老板----墨水
     * */
    /*@Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            if(i%2==0){
                product.setBrand("得力");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.setName("铅笔");
            } else {
              product.setBrand("老板");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product.setName("墨水");
            }
            System.out.println("生产者生产"+product.getBrand() +"----"+product.getName());
        }
    }*/

    //方式2---增加代码块同步锁----但输出无序
    /*@Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            synchronized (product) {
                if (i % 2 == 0) {
                    product.setBrand("得力");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setName("铅笔");
                } else {
                    product.setBrand("老板");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setName("墨水");
                }
                System.out.println("生产者生产" + product.getBrand() + "----" + product.getName());
            }
        }
    }*/

    //方式3//方式4
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                product.setProduct("得力","铅笔");
            } else {
                product.setProduct("老板","墨水");
            }
        }
    }
}
