package rmugattarov.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmugattarov on 18.01.2017.
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println(merge(Arrays.asList(1, 4, 8), Arrays.asList(2, 3, 7, 9)));
    }

//    public static List<Comparable> sort(List<Comparable> list) {
//
//    }

    public static List<Comparable> merge(List<Comparable> leftList, List<Comparable> rightList) {
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
                } else {
                    result.add(leftList.get(leftIndex++));
                }
            }
        }
        return result;
    }
}
