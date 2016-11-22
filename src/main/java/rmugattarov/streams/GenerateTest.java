package rmugattarov.streams;

import java.util.stream.Stream;

/**
 * Created by rmugattarov on 22.11.2016.
 */
public class GenerateTest {
    public static void main(String[] args) {
        Stream.generate(Math::random).limit(20).forEach(System.out::println);
    }
}
