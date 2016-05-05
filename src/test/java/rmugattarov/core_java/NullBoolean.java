package rmugattarov.core_java;

import org.junit.Test;

/**
 * Created by rmugattarov on 05.05.2016.
 */
public class NullBoolean {
    @Test
    public void test() {
        Boolean b = null;
        if (b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
