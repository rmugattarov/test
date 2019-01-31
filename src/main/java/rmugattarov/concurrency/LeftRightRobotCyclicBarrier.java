package rmugattarov.concurrency;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class LeftRightRobotCyclicBarrier {
    public static void main(String[] args) {
        final CyclicBarrier b = new CyclicBarrier(2);
        Thread t1 = new Thread(new LeftRightRunnable("left", b));
        Thread t2 = new Thread(new LeftRightRunnable("right", b));
        t1.start();
        t2.start();
    }

    private static void sleepRandomTime() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class LeftRightRunnable implements Runnable {

        private String s;
        private CyclicBarrier b;

        public LeftRightRunnable(String s, CyclicBarrier b) {
            this.s = s;
            this.b = b;
        }

        @Override
        public void run() {
            while (true) {
                waitForNewIteration();
                waitForLeft();
                System.out.println(s + " " + Thread.currentThread().getName() + " " + LocalDateTime.now());
                notifyRight();
                sleepRandomTime();
            }
        }

        private void notifyRight() {
            if (Objects.equals(s, "left")) {
                synchronized (b) {
                    b.notify();
                }
            }
        }

        private void waitForLeft() {
            if (!Objects.equals(s, "left")) {
                synchronized (b) {
                    try {
                        b.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void waitForNewIteration() {
            try {
                b.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
