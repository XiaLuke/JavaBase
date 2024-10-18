package fork_join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Fork/Join，空闲线程从工作线程中窃取任务
 * ForkJoinPool 线程池
 * ForkJoinTask 是线程中执行的基本类型
 * 使用时使用其子类 RecursiveAction 和 RecursiveTask
 */
public class ForkExecutorService extends RecursiveAction {

    private String str;
    private static final int HOLD = 3;

    public ForkExecutorService(String str) {
        this.str = str;
    }

    @Override
    protected void compute() {
        if (str.length() > HOLD) {
            ForkJoinTask.invokeAll(createSubTasks());
        } else {
            process(str);
        }
    }

    private void process(String str) {
        String result = str.toUpperCase();
        System.out.println("Thread: " + Thread.currentThread().getName() + " result: " + result);
    }

    public List<ForkExecutorService> createSubTasks() {
        List<ForkExecutorService> result = new ArrayList<>();

        result.add(new ForkExecutorService(str.substring(0, str.length() / 2)));
        result.add(new ForkExecutorService(str.substring(str.length() / 2)));

        return result;
    }

    public static void main(String[] args) {
        ForkExecutorService forkExecutorService = new ForkExecutorService("hello world");
        forkExecutorService.compute();
    }
}
