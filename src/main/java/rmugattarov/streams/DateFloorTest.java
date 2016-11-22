package rmugattarov.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rmugattarov on 17.11.2016.
 */
public class DateFloorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        System.out.println(floor(list, "a"));

    }

    public static String floor(List<String> events, String ceiling) {
        return events.stream().filter(e -> e.compareTo(ceiling) <= 0).reduce((a, b) -> b).orElse(null);
    }
}
