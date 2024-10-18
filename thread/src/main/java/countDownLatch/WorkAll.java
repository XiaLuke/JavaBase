package countDownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class WorkAll implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public WorkAll(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
//        doSomeWork();
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }
}

