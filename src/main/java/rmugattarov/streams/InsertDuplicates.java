package rmugattarov.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rmugattarov on 03.08.2017.
 */
public class InsertDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5)

                .collect(Collectors.toList());
        System.out.println(list);
    }
}
