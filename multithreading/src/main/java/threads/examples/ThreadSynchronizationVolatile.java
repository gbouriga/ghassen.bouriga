package threads.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gbouriga on 22/10/15.
 */
public class ThreadSynchronizationVolatile extends Thread {

    private int threadNum;

    //variable will never be cached thread-locally (read/write variable always use the main memory)
    private volatile boolean shutdownThread = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadSynchronizationVolatile.class);

    public ThreadSynchronizationVolatile(int threadNum) {
        this.threadNum = threadNum;
    }

    public void run() {
        while (!shutdownThread) {
            LOGGER.info("Thread {} is running with shutdown status {}", this.threadNum, shutdownThread);
        }
        LOGGER.info("Thread {} is stopping with shutdown status {}", this.threadNum, shutdownThread);

    }

    public void setShutdownThread(boolean shutdownThread) {
        this.shutdownThread = shutdownThread;
    }
}
