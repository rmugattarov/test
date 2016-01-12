package rmugattarov.core_java;

import org.junit.Test;

/**
 * Created by rmugattarov on 12.01.2016.
 */
public class LambdaTest {
    @Test
    public void test_lambda() throws InterruptedException {
        Thread t = new Thread(() -> System.out.printf("Hello, Lambda World!\n"));
        t.start();
        t.join();
    }
}
