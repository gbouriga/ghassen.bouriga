package threads.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gbouriga on 22/10/15.
 */
class ThreadCreationSimple {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadCreationSimple.class);

    public void threadsRun() throws InterruptedException {
        Runnable task1 = () -> {
            for (int i = 0; i <= ThreadConstant.NUMBER_OF_CYCLES; i++) {
                LOGGER.info("Thread 1 is running in loop {}", i);
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i <= ThreadConstant.NUMBER_OF_CYCLES; i++) {
                LOGGER.info("Thread 2 is running in loop {}", i);
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
