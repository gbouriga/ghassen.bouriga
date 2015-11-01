package multithread.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadSynchronizationThreadPools {

    private Long counter = 0L;

    public synchronized void incrementCounter() {
        this.counter++;
    }


    public void processingThreadPools() throws InterruptedException {

        //NUMBER_OF_THREAD_POOLS are executing at the same time
        ExecutorService executorService = Executors.newFixedThreadPool(ThreadConstant.NUMBER_OF_THREAD_POOLS);

        Runnable task1 = () -> incrementCounter();
        Runnable task2 = () -> incrementCounter();

        for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
            //each thread increment counter by 1
            executorService.submit(task1);
            executorService.submit(task2);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

    public Long getCounter() {
        return counter;
    }
}
