package rmugattarov.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rmugattarov on 13.09.2016.
 */
public class RemoveThroughIterator {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList("abc", "def", "ghi"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            iterator.remove();
            list.add(new StringBuilder(next).reverse().toString());
        }
        System.out.println(list);
    }
}
