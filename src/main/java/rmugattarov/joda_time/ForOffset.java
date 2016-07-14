package rmugattarov.joda_time;

import org.joda.time.DateTimeZone;

import java.util.Date;

/**
 * Created by rmugattarov on 14.07.2016.
 */
public class ForOffset {
    public static void main(String[] args) {
        DateTimeZone dateTimeZone = DateTimeZone.forOffsetMillis(5 * 60 * 60 * 1000);
        System.out.println(dateTimeZone);
    }
}
