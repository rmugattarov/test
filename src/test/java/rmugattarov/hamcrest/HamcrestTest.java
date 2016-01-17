package rmugattarov.hamcrest;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Created by rmugattarov on 17.01.2016.
 */
public class HamcrestTest {
    @Test
    public void test_hamcrest() {
        MatcherAssert.assertThat(1, Matchers.greaterThan(0));
    }
}
