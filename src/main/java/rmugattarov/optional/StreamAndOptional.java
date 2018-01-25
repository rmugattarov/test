package rmugattarov.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAndOptional {
    public static void main(String[] args) {
        Optional<Integer> o1 = Optional.empty();
        Optional<Integer> o2 = Optional.empty();
        Optional<Integer> o3 = Optional.of(3);
        Optional<Integer> o4 = Optional.empty();
        Optional<Integer> o5 = Optional.of(7);
        Optional<Integer> o6 = Optional.empty();
        List<Integer> list = Stream.of(o1, o2, o3, o4, o5, o6).map(Optional::get).collect(Collectors.toList());
        System.out.println(list);
    }
}
