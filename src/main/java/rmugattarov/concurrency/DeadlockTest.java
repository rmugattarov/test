package rmugattarov.concurrency;

/**
 * Created by rmugattarov on 09.08.2016.
 */
public class DeadlockTest {
    public static synchronized void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.printf("inside %s\r\n", Thread.currentThread().getName());
            try {
                DeadlockTest.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s starting %s\r\n", threadName, t.getName());
        t.start();
        System.out.printf("%s joining with %s\r\n", threadName, t.getName());
        t.join();
    }
}
