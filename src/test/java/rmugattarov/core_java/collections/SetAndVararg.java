package rmugattarov.core_java.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rmugattarov on 21.03.2016.
 */
public class SetAndVararg {
    @Test
    public void test() {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        m(strings.toArray(new String[strings.size()]));
    }

    private static void m(String... strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
