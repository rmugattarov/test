package rmugattarov.streams;

import java.util.stream.IntStream;

/**
 * Created by rmugattarov on 22.11.2016.
 */
public class IntRangeTest {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        IntStream.range(0, 10).forEach(System.out::println);
    }
}
