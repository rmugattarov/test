package rmugattarov.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rmugattarov on 15.11.2016.
 */
public class FilterTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);
        List<Integer> even = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(even);
        List<Integer> odd = list.stream().filter(e -> e % 2 == 1).collect(Collectors.toList());
        System.out.println(odd);
    }
}
