package threads.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadSynchronizationSynchronized{

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadCreationSimple.class);

    private Long counter = 0L;

    public synchronized void incrementCounter() {
        this.counter++;
    }

    public void threadsRun() throws InterruptedException {

        Runnable task1 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounter();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounter();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        //if the counter is not synchronized value will be wrong (!=ThreadConstant.NUMBER_OF_CYCLES * 2)
        LOGGER.info("Synchronized thread counter {}", counter);
    }

    public Long getCounter() {
        return counter;
    }
}
