package multithread.examples;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by gbouriga on 22/10/15.
 */
@Getter
@Slf4j
public class ThreadSynchronizationSynchronized {

    private Long counter = 0L;

    private final Object locker = new Object();


    private synchronized void incrementCounterByMethodSynchronization() {
        this.counter++;
    }

    private void incrementCounterByCodeBlockLockSynchronization() {
        synchronized (locker) {
            this.counter++;
        }
    }


    public void threadsRunByMethodSynchronization() throws InterruptedException {
        counter = 0L;
        Runnable task1 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounterByMethodSynchronization();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounterByMethodSynchronization();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }


    public void threadsRunByCodeBlockLockSynchronization() throws InterruptedException {
        counter = 0L;
        Runnable task1 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounterByCodeBlockLockSynchronization();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounterByCodeBlockLockSynchronization();
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
