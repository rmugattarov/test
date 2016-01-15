package rmugattarov.core_java.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rmugattarov on 15.01.2016.
 */
public class ArrayListIndexOfTest {
    @Test
    public void test_indexOf() {
        List<String> strings = Arrays.asList("abc", "def", "ghi");
        System.out.printf("\"abc\", \"def\", \"ghi\".indexOf(\"def\") : %d\n", strings.indexOf("def"));
        System.out.printf("\"abc\", \"def\", \"ghi\".indexOf(\"zzz\") : %d\n", strings.indexOf("zzz"));
    }
}
