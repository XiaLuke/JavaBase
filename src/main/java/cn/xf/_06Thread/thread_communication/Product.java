package cn.xf._06Thread.thread_communication;

public class Product {
    //商品名字
    private String name;
    //商品品牌
    private String brand;
    //设置线程状态---红绿灯---true(消费者使用)---false(生产者使用)
    public boolean flag = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //方式3
    /*public synchronized void produce(String brand,String name){
        this.setBrand(brand);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了：" + this.getBrand() + "----" + this.getName());
    }*/
    //方式3
    /*public synchronized void consumption(){
        System.out.println("消费者消费了：" + this.getBrand() + "---" + this.getName());
    }*/

    //方式4
    public synchronized void produce(String brand,String name){
        //当状态属于消费者时
        if(flag==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了：" + this.getBrand() + "----" + this.getName());

        //使用完后改变状态值
        flag = true;
        //唤醒等待的线程
        notify();
    }
    //方式4
    public synchronized void consumption(){
        if(flag==false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费了：" + this.getBrand() + "---" + this.getName());
        flag = false;
        notify();
    }
}
