package rmugattarov.core_java.strings;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by rmugattarov on 04.04.2016.
 */
public class TestMessageFormat {
    @Test
    public void test() {
        System.out.println(MessageFormat.format("asd''asd''asd", "123"));
    }
}
