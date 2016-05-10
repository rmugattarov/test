package rmugattarov.core_java.regex;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by rmugattarov on 10.05.2016.
 */
public class TestMatcher {
    @Test
    public void test() {
        System.out.println(Pattern.compile("aaa").matcher("aaaa").matches());
    }
}
