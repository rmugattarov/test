package rmugattarov.joda_time;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by rmugattarov on 08.07.2016.
 */
public class W3CFormat {
    public static void main(String[] args) {
        System.out.println(new LocalDateTime(new Date(), DateTimeZone.UTC).toDate(TimeZone.getTimeZone("UTC")));
    }
}
