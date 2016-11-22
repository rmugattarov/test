package rmugattarov.streams;

import java.util.stream.Stream;

/**
 * Created by rmugattarov on 22.11.2016.
 */
public class IterateTest {
    public static void main(String[] args) {
        Stream.iterate(1, i -> i+=i).limit(10).forEach(System.out::println);
    }
}
