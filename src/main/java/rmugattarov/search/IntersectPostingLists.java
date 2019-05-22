package rmugattarov.search;

import rmugattarov.arrays.ArrayUtil;
import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class IntersectPostingLists {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] arr1 = RandomUtil.getRandomSortedUniqueElementsArray();
            int[] arr2 = RandomUtil.getRandomSortedUniqueElementsArray();
            System.out.println("1) " + Arrays.toString(arr1));
            System.out.println("2) " + Arrays.toString(arr2));
            System.out.println(Arrays.toString(andNot(arr1, arr2)));
        }
    }

    public static int[] and(int[] leftPL, int[] rightPL) {
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

    public static int[] andNot(int[] leftPL, int[] rightPL) {
        int[] res = new int[leftPL.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int resPointer = 0;

        while (leftPointer < leftPL.length && rightPointer < rightPL.length) {
            int left = leftPL[leftPointer];
            int right = rightPL[rightPointer];
            if (left == right) {
                leftPointer++;
                rightPointer++;
            } else if (left < right) {
                res[resPointer++] = left;
                leftPointer++;
            } else {
                rightPointer++;
            }
        }

        if (leftPointer < leftPL.length) {
            return ArrayUtil.appendRanges(res, 0, resPointer, leftPL, leftPointer, leftPL.length);
        }

        return Arrays.copyOfRange(res, 0, resPointer);
    }

    public static int[] or(int[] leftPL, int[] rightPL) {
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
            return ArrayUtil.appendRanges(res, 0, resPointer, leftPL, leftPointer, leftPL.length);
        }
        if (rightPointer < rightPL.length) {
            return ArrayUtil.appendRanges(res, 0, resPointer, rightPL, rightPointer, rightPL.length);
        }

        return Arrays.copyOfRange(res, 0, resPointer);
    }


}
