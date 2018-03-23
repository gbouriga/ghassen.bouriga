package multithread.examples;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gbouriga on 22/10/15.
 */
@Slf4j
class ThreadCreationSimple {

    public void threadsRun() throws InterruptedException {
        Runnable task1 = () -> {
            for (int i = 0; i <= ThreadConstant.NUMBER_OF_CYCLES; i++) {
                log.info("Thread " + Thread.currentThread().getId() + " is running in loop {}", i);
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i <= ThreadConstant.NUMBER_OF_CYCLES; i++) {
                log.info("Thread " + Thread.currentThread().getId() + " is running in loop {}", i);
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
