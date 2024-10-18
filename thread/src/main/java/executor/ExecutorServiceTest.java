package executor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    private ExecutorService executorService2 = new ThreadPoolExecutor(2, 5, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    private Callable<String> getCallable(String str) {
        return () -> {
            Thread.sleep(3000);
            return str;
        };
    }

    private Runnable getRunnable(String str) {
        return () -> {
            System.out.println(str);
        };
    }

    private List<Callable<String>> getCallableList() {
        ArrayList<Callable<String>> callables = new ArrayList<>();
        callables.add(getCallable("callable 1"));
        callables.add(getCallable("callable 3"));
        callables.add(getCallable("callable 2"));
        return callables;
    }

    @Test
    public void runnableExecute() {

        executorService.execute(getRunnable("hello Runnable"));
    }

    @Test
    public void submit() {
        executorService.submit(getRunnable("data structure"));
        executorService.submit(getCallable("callable data structure"));
    }

    @Test
    public void anyInvokeTest() throws ExecutionException, InterruptedException {
        String s = executorService.invokeAny(getCallableList());
        System.out.println(s);
    }

    @Test
    public void allInvokeTest() throws InterruptedException, ExecutionException {
        List<Future<String>> futures = executorService.invokeAll(getCallableList());
        for (Future<String> future : futures) {
            // get() 是个阻塞方法，需要等待线程池中所有任务执行完毕
            // 任务执行时间不一致，且存在任务可能抛出异常，所以使用try-catch捕获，并设置超时时间
            try {
                String s = future.get(1000, TimeUnit.MILLISECONDS);
                System.out.println(s);
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void executorShutdown() {
        // executorService.shutdown() 方法不会立即停止执行，而是先停止接收新的任务，等待已提交的任务执行完毕后关闭
        // executorService.shutdown();
    }

    @Test
    public void executorShutdownNow() {
        // executorService.shutdownNow() 方法会尝试停止所有正在执行的任务，不再处理等待队列中的任务，并返回等待执行的任务列表
    }

    // 根据上述两种关闭方法，最好的方式先使用shutdown停止接收新任务，当一定时间后，再使用shutdownNow关闭线程池
    @Test
    public void complayShutdown() {
        executorService.shutdown();
        try {
            // 等待一定时间，还未关闭则强制关闭
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    @Test
    public void otherFutureMethod() throws InterruptedException {
        List<Future<String>> futures = executorService.invokeAll(getCallableList());
        for (Future<String> future : futures) {
            // 检查已分配的任务是否已处理
            boolean done = future.isDone();

            // 取消任务执行
            future.cancel(true);

            // 是否已经取消
            future.isCancelled();
        }

    }

    @Test
    public void schduleThread(){

    }
}
