package rmugattarov.concurrency;

import org.junit.Test;

/**
 * Created by rmugattarov on 17.05.2016.
 */
public class Interrupt {

    @Test
    public void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("end");
    }
}
