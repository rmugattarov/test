package rmugattarov.guava;

import com.google.common.base.Joiner;
import org.junit.Test;

/**
 * Created by rmugattarov on 02.03.2016.
 */
public class JoinerSkipNulls {
    @Test
    public void test() {
        System.out.println(Joiner.on(" ").skipNulls().join("one", null, "three ").trim());
    }
}
