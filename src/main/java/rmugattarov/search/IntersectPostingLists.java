package rmugattarov.search;

import org.apache.commons.lang.ArrayUtils;
import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class IntersectPostingLists {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] arr1 = RandomUtil.getRandomSortedUniqueElementsArray();
            int[] arr2 = RandomUtil.getRandomSortedUniqueElementsArray();
            System.out.println("1) " + Arrays.toString(arr1));
            System.out.println("2) " + Arrays.toString(arr2));
            System.out.println(Arrays.toString(disjunct(arr1, arr2)));
        }
    }

    public static int[] conjunct(int[] leftPL, int[] rightPL) {
        int[] res = new int[Math.min(leftPL.length, rightPL.length)];
        int leftPointer = 0;
        int rightPointer = 0;
        int resPointer = 0;

        while (leftPointer < leftPL.length && rightPointer < rightPL.length) {
            int left = leftPL[leftPointer];
            int right = rightPL[rightPointer];
            if (left == right) {
                res[resPointer++] = left;
                leftPointer++;
                rightPointer++;
            } else if (left < right) {
                leftPointer++;
            } else {
                rightPointer++;
            }
        }

        return Arrays.copyOfRange(res, 0, resPointer);
    }

    public static int[] disjunct(int[] leftPL, int[] rightPL) {
        int[] res = new int[leftPL.length + rightPL.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int resPointer = 0;

        while (leftPointer < leftPL.length && rightPointer < rightPL.length) {
            int left = leftPL[leftPointer];
            int right = rightPL[rightPointer];
            if (left == right) {
                res[resPointer++] = left;
                leftPointer++;
                rightPointer++;
            } else if (left < right) {
                res[resPointer++] = left;
                leftPointer++;
            } else {
                res[resPointer++] = right;
                rightPointer++;
            }
        }
        if (leftPointer < leftPL.length) {
            res = Arrays.copyOfRange(res, 0, resPointer);
            int[] remaining = Arrays.copyOfRange(leftPL, leftPointer, leftPL.length);
            return ArrayUtils.addAll(res, remaining);
        }
        if (rightPointer < rightPL.length) {
            res = Arrays.copyOfRange(res, 0, resPointer);
            int[] remaining = Arrays.copyOfRange(rightPL, rightPointer, rightPL.length);
            return ArrayUtils.addAll(res, remaining);
        }

        return Arrays.copyOfRange(res, 0, resPointer);
    }


}
