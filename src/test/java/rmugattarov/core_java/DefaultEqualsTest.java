package rmugattarov.core_java;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmugattarov on 11.01.2016.
 */
public class DefaultEqualsTest {
    @Test
    public void should_be_same_as_double_equals_sign() {
        Object o1 = new Object();
        Object o2 = o1;
        System.out.printf("o1 equals o2 : %b\n", o1.equals(o2));
        Assert.assertSame(o1, o2);
        System.out.printf("o1 == o2 : %b\n", o1 == o2);
        Assert.assertEquals(o1, o2);
    }
}
