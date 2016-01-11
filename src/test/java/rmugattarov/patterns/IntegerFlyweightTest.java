package rmugattarov.patterns;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rmugattarov on 11.01.2016.
 */
public class IntegerFlyweightTest {
    @Test
    public void should_return_same_instance() {
        Integer i1 = Integer.valueOf("77");
        Integer i2 = Integer.valueOf("77");
        System.out.printf("i1 == i2 : %b\n", i1 == i2);
        Assert.assertSame(i1, i2);
        i1 = Integer.valueOf("128");
        i2 = Integer.valueOf("128");
        System.out.printf("i1 == i2 : %b\n", i1 == i2);
        Assert.assertNotSame(i1, i2);
    }
}
