package rmugattarov.core_java;

import org.junit.Test;

/**
 * Created by rmugattarov on 28.04.2016.
 */
public class ArgValueAssign {
    private static class MyClass {
        private MyClass(boolean b) {
            System.out.println("MyClass b = " + b);
        }
    }

    @Test
    public void test() {
        boolean b = false;
        new MyClass(b = true);
    }
}
