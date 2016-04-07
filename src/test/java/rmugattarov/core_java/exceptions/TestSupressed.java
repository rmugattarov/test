package rmugattarov.core_java.exceptions;

import org.junit.Test;

/**
 * Created by rmugattarov on 07.04.2016.
 */
public class TestSupressed {
    @Test
    public void test() {
        try {
            throw new RuntimeException("One");
        } finally {
            throw new RuntimeException("Two");
        }
    }
}
