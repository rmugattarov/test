package rmugattarov.core_java.regex;

import org.junit.Test;

/**
 * Created by rmugattarov on 15.01.2016.
 */
public class SkipWasUsersTest {
    @Test
    public void test_regex() {
        String regex = "(?i)(server:.*)|(/UNAUTHENTICATED)|(defaultwimfilebasedrealm.*)";
        String s1 = "server:qwerty";
        System.out.printf("SERver:qwerty matches %s : %b\n", regex, s1.matches(regex));
        String s2 = "/UNAUTHENTICATED";
        System.out.printf("/unAUTHENTICATED matches %s : %b\n", regex, s2.matches(regex));

    }
}
