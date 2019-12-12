package rmugattarov.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FirstSecondThird {
    CyclicBarrier b1 = new CyclicBarrier(2);
    CyclicBarrier b2 = new CyclicBarrier(2);
    public static void main(String[] args) throws InterruptedException {
        FirstSecondThird o = new FirstSecondThird();
        Thread t1 = new Thread(() -> {
            try {
                o.first();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                o.second();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                o.third();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> l = new LinkedList<>();
        l.add(t1);
        l.add(t2);
        l.add(t3);
        Random r = new Random();
        while (!l.isEmpty()) {
            l.remove(r.nextInt(l.size())).start();
        }
        t1.join();
        t2.join();
        t3.join();
    }

    public void first() throws BrokenBarrierException, InterruptedException {
        System.out.println("first");
        b1.await();
        b1.await();
    }

    public void second() throws BrokenBarrierException, InterruptedException {
        b1.await();
        System.out.println("second");
        b2.await();
        b2.await();
        b1.await();
    }

    public void third() throws BrokenBarrierException, InterruptedException {
        b2.await();
        System.out.println("third");
        b2.await();
    }
}
