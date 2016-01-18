package rmugattarov.core_java.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rmugattarov on 18.01.2016.
 */
public class LinkedListRemovalTest {
    @Test
    public void test_removal() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.printf("list : %s\n", list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next < 5) {
                iterator.remove();
            }
        }
        System.out.printf("list : %s\n", list);
        list.clear();
        System.out.printf("list.indexOf(1) : %d", list.indexOf(1));
    }
}
