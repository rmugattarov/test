package rmugattarov.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmugattarov on 18.01.2017.
 */
public class MergeSort {
    public static long inversionCount = 0;

    public static void main(String[] args) {
        inversionCount = 0;
        System.out.println(sort(Arrays.asList(1,2,3,5,4)));
        System.out.println(inversionCount);
    }

    public static List<? extends Comparable> sort(List<? extends Comparable> list) {
        if (list.size() < 2) {
            return list;
        } else {
            return merge(sort(list.subList(0, list.size() / 2)), sort(list.subList(list.size() / 2, list.size())));
        }
    }

    public static List<? extends Comparable> merge(List<? extends Comparable> leftList, List<? extends Comparable> rightList) {
        int elementCount = leftList.size() + rightList.size();
        List<Comparable> result = new ArrayList<>(elementCount);

        int leftIndex = 0;
        int rightIndex = 0;

        while (elementCount-- > 0) {
            if (leftIndex >= leftList.size()) {
                result.add(rightList.get(rightIndex++));
            } else if (rightIndex >= rightList.size()) {
                result.add(leftList.get(leftIndex++));
            } else {
                if (rightList.get(rightIndex).compareTo(leftList.get(leftIndex)) < 0) {
                    result.add(rightList.get(rightIndex++));
                    inversionCount += leftList.size() - leftIndex;
                } else {
                    result.add(leftList.get(leftIndex++));
                }
            }
        }
        return result;
    }
}
