package multithread.examples;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadSynchronizationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadSynchronizationTest.class);


    private static ThreadSynchronizationSynchronized threadSyncThread;
    private final int expectedCounter = ThreadConstant.NUMBER_OF_CYCLES * 2;

    @BeforeClass
    public static void init() {
        threadSyncThread = new ThreadSynchronizationSynchronized();
    }

    @Test
    public void testThreadSyncByMethodSynchronization() throws InterruptedException {

        //start threads
        threadSyncThread.threadsRunByMethodSynchronization();
        //if the counter is not synchronized value will be wrong (!=ThreadConstant.NUMBER_OF_CYCLES * 2)
        LOGGER.info("Synchronized thread, counter = {}", threadSyncThread.getCounter());
        Assert.assertEquals(expectedCounter, threadSyncThread.getCounter().intValue());

    }

    @Test
    public void testThreadSyncByCodeBlockLock() throws InterruptedException {

        //start threads
        threadSyncThread.threadsRunByCodeBlockLock();
        LOGGER.info("Synchronized thread, counter = {}", threadSyncThread.getCounter());
        Assert.assertEquals(expectedCounter, threadSyncThread.getCounter().intValue());

    }

}