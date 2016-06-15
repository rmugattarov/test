package rmugattarov.dates;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by rmugattarov on 15.06.2016.
 */
public class MonthNames {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DateFormatSymbols(Locale.US).getShortMonths()));
    }
}
