package rmugattarov.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rmugattarov on 16.06.2016.
 */
public class TestExecutorExecuteBlocking {
    private static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("start sleeping");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("woke up");
        }
    }
     public static void main(String[] args) throws InterruptedException {
         ExecutorService executorService = Executors.newSingleThreadExecutor();
         executorService.execute(new MyTask());
         executorService.execute(new MyTask());
         executorService.shutdown();
         executorService.awaitTermination(15, TimeUnit.SECONDS);
         executorService.shutdownNow();
     }
}
