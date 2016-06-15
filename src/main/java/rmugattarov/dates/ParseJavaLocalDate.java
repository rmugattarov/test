package rmugattarov.dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by rmugattarov on 15.06.2016.
 */
public class ParseJavaLocalDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("08-May-1996", DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.US));
        System.out.println(localDate.getMonth());
    }
}
