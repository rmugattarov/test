package rmugattarov.core_java.exceptions;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rmugattarov on 07.04.2016.
 */
public class TestSupressed {
    @Test
    public void test() {
        try {
            try {
                throw new RuntimeException("One");
            } finally {
                throw new RuntimeException("Two");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getSuppressed()));
        }
    }
}
