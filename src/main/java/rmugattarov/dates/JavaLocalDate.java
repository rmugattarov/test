package rmugattarov.dates;

import java.time.LocalDate;

/**
 * Created by rmugattarov on 15.06.2016.
 */
public class JavaLocalDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2016, 6, 15);
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
    }
}
