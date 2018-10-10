package rmugattarov.basics.y2018m10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class VolatileA {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        A o = new A();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            o.c = 4;
            o.c = 5;
            o.c = 6;
        }).start();
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(o.c);
            System.out.println(o.c);
            System.out.println(o.c);
        }).start();
        cyclicBarrier.await();
    }

    private static class A {
        int a = 1;
        int b = 2;
        volatile int c = 3;
    }
}
