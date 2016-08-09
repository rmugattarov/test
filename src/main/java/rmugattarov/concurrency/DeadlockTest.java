package rmugattarov.concurrency;

/**
 * Created by rmugattarov on 09.08.2016.
 */
public class DeadlockTest {
    public static synchronized void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                DeadlockTest.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s starting t\r\n", threadName);
        t.start();
        System.out.printf("%s joining with t\r\n", threadName);
        t.join();
    }
}
