package rmugattarov.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParaStream0 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10)
                .forEach(System.out::println);
        System.out.println("===");
        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEach(System.out::println);
        System.out.println("===");
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("===");
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .parallel()
                .forEach(System.out::println);
    }
}
