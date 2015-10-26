package threads.examples;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadSynchronizationTest {

    @Test
    public void testThreadSyncSynchronized() throws InterruptedException {
        //parallels threads execution
        ThreadSynchronizationSynchronized threadSyncThread1 = new ThreadSynchronizationSynchronized();
        ThreadSynchronizationSynchronized threadSyncThread2 = new ThreadSynchronizationSynchronized();


        //start threads
        threadSyncThread1.threadsRun();
        threadSyncThread2.threadsRun();

        Long expectedCounter = ThreadConstant.NUMBER_OF_CYCLES * 2;
        Assert.assertEquals(expectedCounter, threadSyncThread1.getCounter());

    }

}