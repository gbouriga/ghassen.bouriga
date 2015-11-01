package multithread.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadCreationThreadPools {

    private Long counter = 0L;

    public synchronized void incrementCounter() {
        this.counter++;
    }


    public void processingThreadPools() throws InterruptedException {


        //creates a thread pool with NUMBER_OF_THREAD_POOLS threads executing tasks
        ExecutorService executorService = Executors.newFixedThreadPool(ThreadConstant.NUMBER_OF_THREAD_POOLS);

        Runnable task1 = this::incrementCounter;
        Runnable task2 = this::incrementCounter;

        for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
            //each task is executed by one of the threads in the ExecutorService
            executorService.execute(task1);
            executorService.execute(task2);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

    public Long getCounter() {
        return counter;
    }
}
