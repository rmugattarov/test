package rmugattarov.core_java.regex;

import org.junit.Test;

/**
 * Created by rmugattarov on 15.01.2016.
 */
public class IgnoreCaseTest {
    @Test
    public void should_ignore_case() {
        String s = "JDbc/qwerty";
        System.out.printf("starts with jdbc/ ignore case : %b", s.matches("(?i)jdbc/.+"));
    }
}
