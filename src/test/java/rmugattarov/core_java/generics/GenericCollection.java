package rmugattarov.core_java.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmugattarov on 24.02.2016.
 */
public class GenericCollection {
    @Test
    public void test() {
        List<Object> listObject = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        System.out.printf("listString instanceof List<?> : %b\n", listString instanceof List<?>);
    }
}
