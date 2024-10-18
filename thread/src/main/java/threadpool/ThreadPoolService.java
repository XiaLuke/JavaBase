package threadpool;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java中的线程池包含 Executor、Executors,ExecutorService
 * 其中Executors是一个工具类
 * Executor和ExecutorService 接口用于不同线程池的协同工作
 * Executor中提供execute方法，将Runnable实例提交给线程池
 *
 * java中另外一个线程池 ThreadPoolExecutor
 *  ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
 *  其中关键的参数有：
 *      corePoolSize: 核心线程数，线程池中始终存活的线程数
 *      maximumPoolSize: 最大线程数，线程池中最大的线程数
 *      keepAliveTime: 线程空闲时间，超过这个时间，多余的线程会被销毁
 *  ThreadPoolExecutor的工作流程：
 *    1. 当线程池中的线程数小于corePoolSize时，新提交的任务会创建一个新线程执行任务
 *    2. 当线程池中的线程数大于corePoolSize时，新提交的任务会被放入workQueue中
 *    3. 当workQueue已满时，会创建新的线程执行任务，直到线程数达到maximumPoolSize
 *    4. 当线程数大于maximumPoolSize时，新提交的任务会被拒绝，并抛出异常
 *    5. 当线程池中的线程数大于corePoolSize时，空闲时间超过keepAliveTime时，多余的线程会被销毁
 *  ThreadPoolExecutor常见的创建方法：
 *      newFixedThreadPool(int nThreads): 最大线程数和核心线程数相等，线程数固定
 *      newCachedThreadPool(): 最小线程数为0，最大线程数为Integer.MAX_VALUE，适用于执行很多短期异步任务的小程序
 *      newSingleThreadExecutor(): 只有一个线程的线程池，保证任务按照指定顺序执行
 *
 */
public class ThreadPoolService {
    @Test
    public void executorTest(){
        Executor executor = Executors.newSingleThreadExecutor();
        // 无返回值
        executor.execute(()->{
            System.out.println("线程池执行任务");
        });
    }

    @Test
    public void executorServiceTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> {
            System.out.println("线程池执行任务");
            return "success";
        });
        Thread.sleep(1000);
        Object o = future.get();
        System.out.println(o);
    }

    // ----------------------------------ThreadPoolExecutor----------------------------------
    @Test
    public void threadPoolExecutorTest() throws InterruptedException {
        ThreadPoolExecutor thread = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        thread.submit(() -> {
            System.out.println("线程池执行任务1");
        });
        thread.submit(() -> {
            System.out.println("线程池执行任务2");
        });
        thread.submit(() -> {
            System.out.println("线程池执行任务3");
        });
        System.out.println(thread.getPoolSize()); // 2
        System.out.println(thread.getQueue().size()); // 1
    }

    /**
     * 无最小线程池大小，
     */
    @Test
    public void cacheThreadPool(){
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                System.out.println("线程池执行任务"+ finalI);
            });
        }
        System.out.println(threadPool.getPoolSize()); // 10
        System.out.println(threadPool.getQueue().size()); // 0
    }

    /**
     * 单例线程池对象，最大线程数与核心线程数都为1，keepAliveTime为0
     * 通过newSingleThreadExecutor创建的线程将依次执行
     *
     * 是创建时间循环的理想选择
     */
    @Test
    public void singleThreadPool(){
        AtomicInteger counter = new AtomicInteger();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            counter.set(1);
        });
        executor.submit(() -> {
            counter.compareAndSet(1, 2);
        });
    }

    /**
     * ScheduleThreadPoolExecutor 拓展自ThreadPoolExecutor，增加了其他方法用于实现ScheduleThreadService
     * 1. execute(),允许方法在一定时间后执行一次任务
     * 2. scheduleAtFixedRate(), 允许指定方法在指定初始延迟后执行，然后以一定周期执行，其中period为两个任务开始时间的间隔
     * 3. scheduleWithFixedDelay(), 和scheduleAtFixedRate()类似，但period是前一个任务的结束时间和下一个任务的开始时间的间隔
     *
     */
    @Test
    public void scheduleThreadPoolExecutor() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ScheduledFuture<String> schedule = scheduledExecutorService.schedule(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "延迟一秒执行";
        }, 1, TimeUnit.SECONDS);
        System.out.println(schedule.get());

        // 初始化后1秒执行，然后每隔10秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("延迟一秒后，每隔十秒执行一次1");
        }, 1, 10, TimeUnit.SECONDS);

        // 初始化后1秒执行，然后每隔10秒执行一次
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("延迟一秒后，每隔十秒执行一次2");
        }, 1, 10, TimeUnit.SECONDS);
    }
}
