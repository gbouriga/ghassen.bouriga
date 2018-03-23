package multithread.examples;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by gbouriga on 22/10/15.
 */
@Slf4j
public class ThreadSynchronizationTest {

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
        log.info("Synchronized thread by method synchronization, counter = {}", threadSync.getCounter());
        Assert.assertEquals(expectedCounter, threadSync.getCounter().intValue());

    }

    @Test
    public void testThreadSyncByCodeBlockLockSynchronization() throws InterruptedException {

        //start threads
        threadSync.threadsRunByCodeBlockLockSynchronization();
        log.info("Synchronized thread by code block lock synchronization, counter = {}", threadSync.getCounter());
        Assert.assertEquals(expectedCounter, threadSync.getCounter().intValue());

    }

}