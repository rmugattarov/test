package rmugattarov.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rmugattarov on 15.11.2016.
 */
public class RotateTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);
        Collections.rotate(list, 1);
        System.out.println(list);
    }
}
