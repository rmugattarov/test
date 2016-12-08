package rmugattarov.algorithms;

import com.google.common.collect.Collections2;
import org.apache.commons.collections4.iterators.PermutationIterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by rmugattarov on 08.12.2016.
 */
public class CombExtr {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collection<List<Integer>> permutations = Collections2.permutations(list);
        permutations.forEach(System.out::println);
        System.out.println("=== === === ===");
        PermutationIterator<Integer> permutationIterator = new PermutationIterator<>(list);
        while (permutationIterator.hasNext()) {
            System.out.println(permutationIterator.next());
        }
    }
}
