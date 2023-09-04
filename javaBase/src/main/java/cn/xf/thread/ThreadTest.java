package cn.xf.thread;

/**
 * 线程生命周期
 * <p>
 * 新建，就绪，运行，阻塞，死亡
 * <p>
 * 新建：使用new或Thread类或其他子类创建的线程，这些线程对象处于新建状态
 * 就绪：线程对象调用了start()方法后，线程进入就绪状态
 * 运行：线程获取到JVM的资源进行调度
 * 阻塞：线程执行了sleep,suspend等方法，失去所占资源后
 * 等待阻塞：运行状态中的线程执行wait()方法，使线程进入到等待阻塞状态
 * 同步阻塞：线程获取synchronized同步锁失败
 * 其他阻塞：调用sleep()或join()发生I/O请求时
 * 死亡：运行状态线程完成任务或其他终止条件发生时
 * <p>
 * <p>
 * 创建线程方法
 * <p>
 * 1.继承Thread类
 * 2.实现Runnable接口
 * 3.实现Callable接口
 */
public class ThreadTest{
    public static void main(String[] args) {
        ThreadDemo thread1 = new ThreadDemo("thread1");

        ThreadDemo thread2 = new ThreadDemo("thread2");

        thread1.start();
        thread2.start();
    }
}
class ThreadDemo extends Thread {
    private Thread thread;
    private String threadName;


    public ThreadDemo(String name) {
        this.threadName = name;
        System.out.println("创建得到线程名称为：" + name);
    }

    // run方法
    public void run() {
        System.out.println("当前运行线程名：" + threadName);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("运行线程"+threadName+","+i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 重写start方法，用于调用run方法
    public void start() {
        if(thread == null){
            thread = new Thread(this,threadName);
            thread.start();
        }
    }
}
