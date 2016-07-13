package rmugattarov.date;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by rmugattarov on 12.07.2016.
 */
public class TimestampToDate {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(new Date().getTime() - 5 * 60 * 60 * 1000);
        System.out.println(timestamp);
        LocalDateTime localDateTime = new LocalDateTime(timestamp);
        System.out.println(localDateTime);
        System.out.println(localDateTime.toDate(DateTimeZone.UTC.toTimeZone()));
        System.out.println(localDateTime.toDate());
    }
}
