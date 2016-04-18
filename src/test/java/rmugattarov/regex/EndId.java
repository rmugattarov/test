package rmugattarov.regex;

import org.junit.Test;

/**
 * Created by rmugattarov on 18.04.2016.
 */
public class EndId {
    @Test
    public void test() {
        String s = "aslkfh2089374{4C1C3DD3-A789-437D-BF15-1D07ADE712F9}";
        System.out.println(s.matches(".*\\{\\}$"));
    }
}
