package rmugattarov.collections;

import java.util.TreeSet;

/**
 * Created by rmugattarov on 16.06.2016.
 */
public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Z");
        set.add("Y");
        set.add("X");
        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println(set);
        System.out.println(set.first());
        System.out.println(set.last());
    }
}
