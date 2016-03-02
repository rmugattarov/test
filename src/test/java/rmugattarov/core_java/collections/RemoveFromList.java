package rmugattarov.core_java.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rmugattarov on 02.03.2016.
 */
public class RemoveFromList {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(list);
    }
}
