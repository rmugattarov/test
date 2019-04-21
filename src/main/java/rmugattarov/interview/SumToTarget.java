package rmugattarov.interview;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SumToTarget {
    public static void main(String[] args) {
        Set<List<Integer>> result = new HashSet<>();
        AtomicInteger count = new AtomicInteger(0);
        compose(Arrays.asList(2,3,5), 10, new ArrayList<>(), result, count);
        System.out.println("count " + count);
        result.stream().forEach(System.out::println);
    }

    private static void compose(List<Integer> candidates, Integer target, List<Integer> path, Set<List<Integer>> result, AtomicInteger count) {
        count.incrementAndGet();
        if (candidates.size() == 0) return;
        Collections.sort(candidates);
        if (candidates.get(0) > target) return;
        for (Integer i : candidates) {
            if (target.equals(i)) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(i);
                Collections.sort(newPath);
                result.add(newPath);
            }
        }
        for (Integer i : candidates) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(i);
            compose(candidates, target - i, newPath, result, count);
        }
    }
}
