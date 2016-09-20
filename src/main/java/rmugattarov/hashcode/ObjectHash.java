package rmugattarov.hashcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rmugattarov on 20.09.2016.
 */
public class ObjectHash {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(new Object());
        }
        int i = 0;
        for (Object o : set) {
            System.out.printf("element %d, hash : %d\r\n", ++i, o.hashCode());
        }
    }
}
