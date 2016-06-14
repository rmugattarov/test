package rmugattarov.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rmugattarov on 14.06.2016.
 */
public class TestCachedExecutorService {
    private static class MyTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("activeCount : " + Thread.activeCount());
            System.out.println("thread id : " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        System.out.println("activeCount : " + Thread.activeCount());
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(new MyTask());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cachedThreadPool.shutdown();
        try {
            cachedThreadPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cachedThreadPool.shutdownNow();
            System.out.println("activeCount : " + Thread.activeCount());
        }
    }
}
