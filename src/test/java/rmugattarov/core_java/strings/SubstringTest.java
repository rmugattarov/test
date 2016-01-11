package rmugattarov.core_java.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmugattarov on 11.01.2016.
 */
public class SubstringTest {
    @Test
    public void test_substring() {
        String s = "Hello, world!";
        System.out.printf("\"Hello, world!\".substring(7) : %s\n", s.substring(7));
        System.out.printf("\"Hello, world!\".substring(0, 5) : %s\n", s.substring(0, 5));
        Assert.assertEquals("world!", s.substring(7));
        Assert.assertEquals("Hello", s.substring(0, 5));
    }
}
