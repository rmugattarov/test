package rmugattarov.algorithms.coursera;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by rmugattarov on 17.01.2017.
 */
public class Week2ProgrAssign {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>(100000);
        try (Stream<String> lines = Files.lines(Paths.get("src/main/java/rmugattarov/algorithms/coursera/IntegerArray.txt"))) {
            lines.forEach(s -> list.add(Integer.valueOf(s)));
        }
        System.out.println(countInversionsLoop(list));
    }

    private static long countInversionsLoop(List<Integer> list) {
        long count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            Integer left = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Integer right = list.get(j);
                if (left > right) {
                    count++;
                }
            }
        }
        return count;
    }
}
