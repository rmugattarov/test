package rmugattarov.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by rmugattarov on 23.05.2017.
 */
public class TestReduce {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("d", "", "");
        Optional<Boolean> reduce = list.stream().map(String::isEmpty).reduce((l, r) -> l && r);
        System.out.println(reduce.get());
    }
}
