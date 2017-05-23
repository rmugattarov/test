package rmugattarov.operators;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by rmugattarov on 23.05.2017.
 */
public class BooleanAndEq {
    public static void main(String[] args) {
        boolean b = true;
        boolean arr[] = {true, true, false};
        System.out.println(b);
        for (boolean x: arr) {
            b &= x;
            System.out.println(b);
        }
        System.out.println(b);

        System.out.println("=======");
        List<Boolean> list = Arrays.asList(true, true, true);
        Boolean reduce = list.stream().reduce(true, (l, r) -> l && r);
        System.out.println(reduce);
    }
}
