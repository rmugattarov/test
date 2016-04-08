package rmugattarov.core_java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmugattarov on 08.04.2016.
 */
public class CastNull {
    @Test
    public void test() {
        Map map = new HashMap<>();
        String s = (String) map.get("abc");
        System.out.println(s);
    }
}
