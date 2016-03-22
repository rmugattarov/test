package rmugattarov.core_java;

import org.junit.Test;

/**
 * Created by rmugattarov on 19.01.2016.
 */
public class ParseBooleanTest {
    @Test
    public void test_parse_boolean() {
        System.out.printf("Boolean.parseBoolean(null) : %b\n", Boolean.parseBoolean(null));
        System.out.printf("Boolean.parseBoolean(\"trUe\") : %b\n", Boolean.parseBoolean("trUe"));
        System.out.printf("Boolean.parseBoolean(\"\") : %b\n", Boolean.parseBoolean(""));
    }
}
