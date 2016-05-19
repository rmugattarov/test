package rmugattarov.core_java.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rmugattarov on 19.05.2016.
 */
public class EndsWith {
    @Test
    public void test() {
        Pattern pattern = Pattern.compile("(?i).*xml");
        Matcher matcher = pattern.matcher("123.XML");
        System.out.println(matcher.matches());
    }
}
