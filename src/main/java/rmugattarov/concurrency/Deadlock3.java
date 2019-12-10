package rmugattarov.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Deadlock3 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        CyclicBarrier b = new CyclicBarrier(2);
        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                System.out.println("t1 acqrd o1");
                try {
                    b.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s passed barrier\n", Thread.currentThread().getName());
                synchronized (o2) {
                    System.out.println("t1 acqrd o2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o2) {
                System.out.println("t2 acqrd o2");
                try {
                    b.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s passed barrier\n", Thread.currentThread().getName());
                synchronized (o1) {
                    System.out.println("t2 acqrd o1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
