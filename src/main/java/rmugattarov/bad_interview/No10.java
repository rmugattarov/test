package rmugattarov.bad_interview;

import java.util.Set;
import java.util.TreeSet;

public class No10 {
    public static void main(String[] args) {
        Set<Number> set = new TreeSet<>();

        set.add(1);
        set.add(1L);
        set.add(1.0);

        System.out.println(set.size());
    }
}
