package rmugattarov.core_java.dates;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rmugattarov on 10.05.2016.
 */
public class GetYear {
    @Test
    public void test() {
        System.out.println(new Date().getYear());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.YEAR));
    }
}
