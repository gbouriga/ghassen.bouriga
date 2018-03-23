package multithread.examples;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by gbouriga on 22/10/15.
 */
@RequiredArgsConstructor
@Slf4j
public class ThreadSynchronizationVolatile extends Thread {

    @NonNull
    private Integer threadNum;

    //variable will never be cached thread-locally (read/write variable always use the main memory)
    private volatile boolean shutdownThread = false;


    public void run() {
        while (!shutdownThread) {
            log.info("Thread {} is running with shutdown status {}", this.threadNum, shutdownThread);
        }
        log.info("Thread {} is stopping with shutdown status {}", this.threadNum, shutdownThread);

    }

    public void setShutdownThread(boolean shutdownThread) {
        this.shutdownThread = shutdownThread;
    }
}
