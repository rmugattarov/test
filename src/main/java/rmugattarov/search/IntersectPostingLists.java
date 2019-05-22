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
            System.out.println(Arrays.toString(or(arr1, arr2)));
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
            return appendRanges(res, leftPL, resPointer, leftPointer);
        }

        return Arrays.copyOfRange(res, 0, resPointer);
    }

    private static int[] appendRanges(int[] left, int[] right, int leftEnd, int rightStart) {
        left = Arrays.copyOfRange(left, 0, leftEnd);
        int[] remaining = Arrays.copyOfRange(right, rightStart, right.length);
        return ArrayUtils.addAll(left, remaining);
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
            return appendRanges(res, leftPL, resPointer, leftPointer);
        }
        if (rightPointer < rightPL.length) {
            return appendRanges(res, rightPL, resPointer, rightPointer);
        }

        return Arrays.copyOfRange(res, 0, resPointer);
    }


}
