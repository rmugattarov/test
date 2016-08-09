package rmugattarov.concurrency;

/**
 * Created by rmugattarov on 09.08.2016.
 */
public class DeadlockTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                DeadlockTest.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        synchronized (DeadlockTest.class) {
            System.out.println("starting t");
            t.start();
            System.out.println("joining with t");
            t.join();
        }
    }
}
