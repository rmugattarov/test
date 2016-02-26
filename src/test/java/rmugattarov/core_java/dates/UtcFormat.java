package rmugattarov.core_java.dates;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by rmugattarov on 26.02.2016.
 */
public class UtcFormat {
    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        df.setCalendar(calendar);
        System.out.printf("%s\n", df.format(new Date()));
    }
}
