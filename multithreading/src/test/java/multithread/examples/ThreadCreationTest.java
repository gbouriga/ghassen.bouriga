package multithread.examples;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by gbouriga on 22/10/15.
 */
@Slf4j
public class ThreadCreationTest {


    private static ThreadCreationThreadPools threadSyncPools;


    @BeforeClass
    public static void init() {
        threadSyncPools = new ThreadCreationThreadPools();
    }

    @Test
    public void testThreadCreationThread() throws InterruptedException {
        //parallels threads execution
        ThreadCreationExtendThread threadCreationThread1 = new ThreadCreationExtendThread(1);
        ThreadCreationExtendThread threadCreationThread2 = new ThreadCreationExtendThread(2);

        //start threads
        threadCreationThread1.start();
        threadCreationThread2.start();

        //prevent test from finishing before the creation thread has complete
        threadCreationThread1.join();
        threadCreationThread2.join();

    }

    @Test
    public void testThreadCreationRunnable() throws InterruptedException {
        //parallels threads execution
        ThreadCreationImplementRunnable threadCreationRunnable1 = new ThreadCreationImplementRunnable(1);
        ThreadCreationImplementRunnable threadCreationRunnable2 = new ThreadCreationImplementRunnable(2);

        Thread thread1 = new Thread(threadCreationRunnable1);
        Thread thread2 = new Thread(threadCreationRunnable2);


        //start threads
        thread1.start();
        thread2.start();

        //prevent test from finishing before the creation thread has complete
        thread1.join();
        thread2.join();

    }

    @Test
    public void testThreadCreationSimple() throws InterruptedException {
        //parallels threads execution
        ThreadCreationSimple threadCreationSimple = new ThreadCreationSimple();

        threadCreationSimple.threadsRun();
    }

    @Test
    public void testThreadSynchronizationVolatile() throws InterruptedException {
        //parallels threads execution
        ThreadSynchronizationVolatile threadSynchronizationVolatile1 = new ThreadSynchronizationVolatile(1);
        ThreadSynchronizationVolatile threadSynchronizationVolatile2 = new ThreadSynchronizationVolatile(2);

        //start threads
        threadSynchronizationVolatile1.start();
        threadSynchronizationVolatile2.start();

        threadSynchronizationVolatile1.setShutdownThread(true);//shutting down the first thread hasn't any impact in thread 2
        threadSynchronizationVolatile2.join(500);

    }

    @Test
    public void testThreadSynchronizationThreadPools() throws InterruptedException {

        //start threads
        threadSyncPools.processingThreadPools();
        log.info("Thread pools = {} , counter = {}", ThreadConstant.NUMBER_OF_THREAD_POOLS, threadSyncPools.getCounter());
        int expectedCounter = ThreadConstant.NUMBER_OF_CYCLES * 2;
        Assert.assertEquals(expectedCounter, threadSyncPools.getCounter().intValue());

    }
}