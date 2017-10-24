package rmugattarov.streams;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindsFirstVsIteratorNext {
    private static final long ITERATIONS = 1_000_000_000L;

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).collect(Collectors.toList());
        long iteratorTime = 0;
        for (long i = 0; i < ITERATIONS; i++) {
            Date start = new Date();
            Integer max = Collections.max(list);
            iteratorTime += new Date().getTime() - start.getTime();
        }
        long streamTime = 0;
        for (long i = 0; i < ITERATIONS; i++) {
            Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
            Date start = new Date();
            Integer integer = stream.max(Integer::compare).get();
            streamTime += new Date().getTime() - start.getTime();
        }
        System.out.println("Iterator time : " + iteratorTime);
        System.out.println("Stream time : " + streamTime);
    }
}
