package rmugattarov.core_java.dates;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by rmugattarov on 06.05.2016.
 */
public class RandomDateParse {
    public static final String LOG_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
    @Test
    public void test() throws ParseException {
//        String s = "Fri May 06 07:41:37 MSK 2016";
        String s = "Fri May 06 07:41:30 MSK 2016";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LOG_DATE_FORMAT, Locale.US);
        System.out.println(simpleDateFormat.parse(s));
    }
}
