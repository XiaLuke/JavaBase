package cn.xf._06Thread.thread_communication;

public class Test {
    public static void main(String[] args) {
        //共享的商品：
        Product p = new Product();
        //创建生产者和消费者线程：
        Producer producer = new Producer(p);
        Consumer consumer = new Consumer(p);
        producer.start();
        consumer.start();
    }
}
