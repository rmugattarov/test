package rmugattarov.concurrency;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ContextSwitch {
    public static void main(String[] args) {
        BlockingQueue<Long> q = new ArrayBlockingQueue<>(1);
        Thread c = new Thread(() -> {
            long time = new Date().getTime();
            try {
                System.out.println("c " + time + " " + q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread p = new Thread(() -> {
            long time = new Date().getTime();
            System.out.println("p " + time);
            try {
                q.put(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        c.start();
        p.start();
    }
}
