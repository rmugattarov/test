package rmugattarov.core_java.strings;

import org.junit.Test;

/**
 * Created by rmugattarov on 14.01.2016.
 */
public class ValueOfTest {
    @Test(expected = NullPointerException.class)
    public void test_valueof() {
        System.out.printf("String.valueOf(null) : %s", String.valueOf(null));
    }
}
