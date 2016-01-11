package rmugattarov.core_java;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmugattarov on 11.01.2016.
 */
public class StringEqualsTest {
    @Test
    public void should_be_same_as_double_equals_sign() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.printf("s1 equals s2 : %s\n", s1.equals(s2));
        System.out.printf("s1 == s2 : %s\n", s1 == s2);
        Assert.assertEquals(s1, s2);
        Assert.assertSame(s1, s2);
    }
}
