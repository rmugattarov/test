package rmugattarov.core_java.dates;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by rmugattarov on 15.01.2016.
 */
public class ParseNull {
    @Test(expected = NullPointerException.class)
    public void test_null() {
        try {
            System.out.printf("%s", new SimpleDateFormat("yyyy-MM-dd").parse(null));
        } catch (ParseException e) {
            System.out.printf("ParseException:\n%s\n", e.getMessage());
        }
    }
}
