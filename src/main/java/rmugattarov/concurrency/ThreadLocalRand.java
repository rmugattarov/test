package rmugattarov.concurrency;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rmugattarov on 13.09.2016.
 */
public class ThreadLocalRand {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt());
        }
    }
}
