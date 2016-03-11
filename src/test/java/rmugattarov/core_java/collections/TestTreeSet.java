package rmugattarov.core_java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by rmugattarov on 11.03.2016.
 */
public class TestTreeSet {
    @Test
    public void test() {
        Set<String> set = new TreeSet<>();
        set.add("3");
        set.add("2");
        set.add("1");
        List<String> list = new ArrayList<>();
        list.addAll(set);
        System.out.println(list);
    }
}
