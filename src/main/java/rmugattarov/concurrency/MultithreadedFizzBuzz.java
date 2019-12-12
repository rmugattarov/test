package rmugattarov.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultithreadedFizzBuzz {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
        BlockingQueue<Integer> q3 = new ArrayBlockingQueue<>(10);
        BlockingQueue<Integer> q5 = new ArrayBlockingQueue<>(10);
        CyclicBarrier b1 = new CyclicBarrier(2);
        CyclicBarrier b2 = new CyclicBarrier(2);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    q.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                q.put(-1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer");
        Thread t2 = new Thread(() -> {
            try {

                int i = q.take();
                while (i != -1) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        System.out.println(i + " FizzBuzz " + Thread.currentThread().getName());
                    } else if (i % 3 == 0) {
                        q3.put(i);
                        b1.await();
                    } else if (i % 5 == 0) {
                        q5.put(i);
                        b2.await();
                    } else {
                        System.out.println(i + " " + Thread.currentThread().getName());
                    }
                    i = q.take();
                }
                q3.put(i);
                q5.put(i);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "3 and 5");
        Thread t3 = new Thread(() -> {
            try {
                int i = q3.take();
                while (i != -1) {
                    System.out.println(i + " Fizz " + Thread.currentThread().getName());
                    b1.await();
                    i = q3.take();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "3s");
        Thread t4 = new Thread(() -> {
            try {
                int i = q5.take();
                while (i != -1) {
                    System.out.println(i + " Buzz " + Thread.currentThread().getName());
                    b2.await();
                    i = q5.take();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "5s");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
