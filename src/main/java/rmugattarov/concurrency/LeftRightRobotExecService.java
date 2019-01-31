package rmugattarov.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class LeftRightRobotExecService {
    private static final ExecutorService left = Executors.newFixedThreadPool(1);
    private static final ExecutorService right = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(1);
        while (true) {
            s.acquire();
            left.submit(() -> {
                System.out.println("left " + Thread.currentThread().getName());
                right.submit(() -> {
                    System.out.println("right " + Thread.currentThread().getName());
                    sleepRandomTime();
                    s.release();
                });
                sleepRandomTime();
            });

        }
    }

    private static void sleepRandomTime() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
