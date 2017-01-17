package rmugattarov.algorithms.coursera;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by rmugattarov on 17.01.2017.
 */
public class Week2ProgrAssign {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>(100000);
        try (Stream<String> lines = Files.lines(Paths.get("src/main/java/rmugattarov/algorithms/coursera/IntegerArray.txt"))) {
            lines.forEach(s -> list.add(Integer.valueOf(s)));
        }
        System.out.println(count(list));
        System.out.println(count);
    }

    private static int count(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        } else if (list.size() == 1) {
            count++;
            return 1;
        } else {
            return count(list.subList(0, list.size() / 2)) + count(list.subList(list.size() / 2, list.size()));
        }
    }
}
