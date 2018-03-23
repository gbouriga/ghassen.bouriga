package multithread.examples;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by gbouriga on 22/10/15.
 */
@AllArgsConstructor
@Slf4j
public class ThreadCreationImplementRunnable implements Runnable {

    private int threadNum;

    public void run() {
        for (int i = 0; i <= ThreadConstant.NUMBER_OF_CYCLES; i++) {
            log.info("Thread {} is running in loop {}", this.threadNum, i);
        }
    }
}
