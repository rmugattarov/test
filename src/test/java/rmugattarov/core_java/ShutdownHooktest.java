package rmugattarov.core_java;

import org.junit.Test;

/**
 * Created by rmugattarov on 18.01.2016.
 */
public class ShutdownHooktest {
    @Test
    public void test_shutdown_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("This is a shutdown hook!");
        }));
        System.out.println("1");
    }
}
