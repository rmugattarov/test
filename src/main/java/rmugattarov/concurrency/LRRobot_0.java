package rmugattarov.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class LRRobot_0 {
    private static final AtomicInteger stepsShared = new AtomicInteger();

    public static void main(String[] args) {
        Thread l = new Thread(new LeftRunnable(stepsShared));
        Thread r = new Thread(new RightRunnable(stepsShared));
        l.start();
        r.start();
        while (true) {
            synchronized (stepsShared) {
                stepsShared.notify();
            }
        }
    }

    private static class LeftRunnable implements Runnable {
        private AtomicInteger i;

        private LeftRunnable(AtomicInteger i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (i) {
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (i) {
                    if ((i.get() & 1) == 0) {
                        System.out.println("left");
                        i.incrementAndGet();
                        i.notify();
                    }
                }
            }
        }
    }

    private static class RightRunnable implements Runnable {
        private AtomicInteger i;

        private RightRunnable(AtomicInteger i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (i) {
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (i) {
                    if ((i.get() & 1) == 1) {
                        System.out.println("right");
                        i.incrementAndGet();
                        i.notify();
                    }
                }
            }
        }
    }
}
