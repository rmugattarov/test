package rmugattarov.core_java.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmugattarov on 11.03.2016.
 */
public class GenericParams {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        m(list);
    }

    private static void m(List<?> list) {
        System.out.println(list);
    }
}
