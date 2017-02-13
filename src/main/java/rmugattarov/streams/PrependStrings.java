package rmugattarov.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rmugattarov on 13.02.2017.
 */
public class PrependStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list = list.stream().map(e -> "1 " + e).collect(Collectors.toList());
        System.out.println(list);
    }
}
