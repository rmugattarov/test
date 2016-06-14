package rmugattarov.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by rmugattarov on 14.06.2016.
 */
public class ProdCons {

    private static class Prod implements Runnable {
        public static final Object END_OF_QUEUE = new Object();
        private static final BlockingQueue queue = new LinkedBlockingQueue();

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put("value " + i);
                    Thread.sleep(1000);

                }
                queue.put(END_OF_QUEUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public Object take() {
            try {
                return queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Prod prod = new Prod();
        new Thread(prod).start();
        Object take = prod.take();

        while (take != Prod.END_OF_QUEUE) {
            System.out.println(take);
            take = prod.take();
        }
    }
}
