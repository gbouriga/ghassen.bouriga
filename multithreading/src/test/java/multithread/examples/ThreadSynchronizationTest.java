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


    private static ThreadSynchronizationSynchronized threadSync;
    private final int expectedCounter = ThreadConstant.NUMBER_OF_CYCLES * 2;

    @BeforeClass
    public static void init() {
        threadSync = new ThreadSynchronizationSynchronized();
    }

    @Test
    public void testThreadSyncByMethodSynchronization() throws InterruptedException {

        //start threads
        threadSync.threadsRunByMethodSynchronization();
        //if the counter is not synchronized value will be wrong (!=ThreadConstant.NUMBER_OF_CYCLES * 2)
        LOGGER.info("Synchronized thread by method synchronization, counter = {}", threadSync.getCounter());
        Assert.assertEquals(expectedCounter, threadSync.getCounter().intValue());

    }

    @Test
    public void testThreadSyncByCodeBlockLockSynchronization() throws InterruptedException {

        //start threads
        threadSync.threadsRunByCodeBlockLockSynchronization();
        LOGGER.info("Synchronized thread by code block lock synchronization, counter = {}", threadSync.getCounter());
        Assert.assertEquals(expectedCounter, threadSync.getCounter().intValue());

    }

}