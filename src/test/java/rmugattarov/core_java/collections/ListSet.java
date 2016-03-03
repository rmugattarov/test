package rmugattarov.core_java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmugattarov on 03.03.2016.
 */
public class ListSet {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        list.set(1, "xxx");
        System.out.println(list);
    }
}
