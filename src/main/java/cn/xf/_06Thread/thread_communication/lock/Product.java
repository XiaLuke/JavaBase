package cn.xf._06Thread.thread_communication.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    //商品类
    // 品牌
    private String brand;
    // 名字
    private String name;
    //声明一个Lock锁：
    Lock lock = new ReentrantLock();
    //搞一个生产者的等待队列：
    Condition produceCondition = lock.newCondition();
    //搞一个消费者的等待队列：
    Condition consumeCondition = lock.newCondition();
    //引入一个灯：true:红色  false 绿色
    boolean flag = false;//默认情况下没有商品 让生产者先生产  然后消费者再消费

    // setter,getter方法；
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //生产商品
    public void setProduct(String brand, String name) {
        lock.lock();
        try {
            if (flag == true) {//灯是红色，证明有商品，生产者不生产，等着消费者消费
                try {
                    //wait();在Lock中不使用
                    //生产者阻塞，生产者进入等待队列中
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //灯是绿色的，就生产：
            this.setBrand(brand);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setName(name);
            //将生产信息做一个打印：
            System.out.println("生产者生产了：" + this.getBrand() + "---" + this.getName());
            //生产完以后，灯变色：变成红色：
            flag = true;
            //告诉消费者赶紧来消费：notify(),在Lock中不使用
            consumeCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    //消费商品：
    public void getProduct() {
        lock.lock();
        try {
            if (!flag) {//flag == false没有商品，等待生产者生产：
                try {
                    //wait();在Lock中不使用
                    //消费者等待，消费者线程进入等待队列：
                    consumeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //有商品，消费：
            System.out.println("消费者消费了：" + this.getBrand() + "---" + this.getName());
            //消费完：灯变色：
            flag = false;
            //通知生产者生产：notify();在Lock中不使用
            produceCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}