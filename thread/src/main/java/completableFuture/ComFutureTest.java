package completableFuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * CompletableFuture 是java8中提供的异步编程工具，
 * 在CompletableFuture内部执行任务时，调用complete()完成任务，将结果传给CompletableFuture
 * 在通过get()方法获取结果时，如果任务未完成，会阻塞当前线程，直到任务完成
 */
public class ComFutureTest {
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            System.out.println("线程池执行任务");
            future.complete("success");
        });

        System.out.println(future.get());
    }

    @Test
    public void multiMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";});
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello2";});
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello3";});

        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3);

        System.out.println(allOf.join());
        System.out.println(allOf.get());

        System.out.println(future2.isDone());
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "简单")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "教程"));
        System.out.println(completableFuture.get());
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        CompletableFuture<Boolean> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> " World"), (s1, s2) -> s1.equals(s2));
        System.out.println(completableFuture.get());
    }
}
