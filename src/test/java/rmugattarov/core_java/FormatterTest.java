package rmugattarov.core_java;

import org.junit.Test;

import java.util.Formatter;

/**
 * Created by rmugattarov on 11.01.2016.
 */
public class FormatterTest {
    @Test
    public void should_print_formatted_message() {
        System.out.println(new Formatter().format("Test args %s, %d", "string arg", 123));
    }
}
