package rmugattarov.strings;

import java.util.Date;

/**
 * Created by rmugattarov on 17.06.2016.
 */
public class TestTimeFormat {
    public static void main(String[] args) {
        System.out.printf("Duke's Birthday: %1$tH:%1$tM:%1$tS", new Date());
    }
}
