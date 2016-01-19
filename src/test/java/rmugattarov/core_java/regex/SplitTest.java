package rmugattarov.core_java.regex;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rmugattarov on 19.01.2016.
 */
public class SplitTest {
    @Test
    public void test_aplit() {
        String s = "server:%|/UNAUTHENTICATED|defaultwimfilebasedrealm%";
        System.out.printf("%s", Arrays.asList(s.split("\\|")));
    }

}
