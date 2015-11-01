package multithread.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadSynchronizationSynchronized {

    private Long counter = 0L;

    private List<Long> worker1 = new ArrayList<>();
    private List<Long> worker2 = new ArrayList<>();

    private Object locker1 = new Object();
    private Object locker2 = new Object();

    public synchronized void incrementCounter() {
        this.counter++;
    }

    public void threadsRunByMethodSynchronization() throws InterruptedException {

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

    }

    public Long getCounter() {
        return counter;
    }

    private int updateWorker1ByCodeBlockLock() {
        synchronized (locker1) {
            worker1.add(null);
        }

        return worker1.size();
    }

    private int updateWorker2ByCodeBlockLock() {
        synchronized (locker2) {
            worker2.add(null);
        }
        return worker2.size();
    }

    private int updateWorker() {
        for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
            updateWorker1ByCodeBlockLock();
            updateWorker2ByCodeBlockLock();
        }
        return worker1.size() + worker2.size();
    }

    public void workersCaller() throws InterruptedException {
        Runnable task1 = () -> updateWorker();
        Runnable task2 = () -> updateWorker();

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

    public List<Long> getWorker1() {
        return worker1;
    }

    public List<Long> getWorker2() {
        return worker2;
    }


}
