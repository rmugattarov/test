package rmugattarov.concurrency;

import java.util.concurrent.*;

public class LeftRightRobotExecService {
    private static final ExecutorService left = Executors.newFixedThreadPool(1);
    private static final ExecutorService right = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        while (true) {
            left.submit(() -> {
                System.out.println("left");
                return null;
            }).get();
            Thread.sleep(1000);
            right.submit(() -> {
                System.out.println("right");
                return null;
            }).get();
        }
    }
}
