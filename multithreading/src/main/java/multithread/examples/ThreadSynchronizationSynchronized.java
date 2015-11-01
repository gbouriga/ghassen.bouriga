package multithread.examples;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadSynchronizationSynchronized {

    private Long counter = 0L;

    private Object locker1 = new Object();
    private Object locker2 = new Object();


    public synchronized void incrementCounterSynchronized() {
        this.counter++;
    }

    public void incrementCounterNonSynchronized() {
        this.counter++;
    }


    public void threadsRunByMethodSynchronization() throws InterruptedException {
        counter = 0L;
        Runnable task1 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounterSynchronized();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                incrementCounterSynchronized();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }


    public void threadsRunByCodeBlockLock() throws InterruptedException {
        counter = 0L;
        Runnable task1 = () -> {
            synchronized (locker1) {
                for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                    incrementCounterNonSynchronized();
                }
            }
        };

        Runnable task2 = () -> {
            synchronized (locker2) {
                for (int i = 0; i < ThreadConstant.NUMBER_OF_CYCLES; i++) {
                    incrementCounterNonSynchronized();
                }
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


}
