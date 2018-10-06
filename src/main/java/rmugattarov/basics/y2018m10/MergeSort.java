package rmugattarov.basics.y2018m10;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int[] randomArray = getRandomArray();
        System.out.println(Arrays.toString(randomArray));
        int[] sorted = sort(randomArray);
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] sort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int count = left.length + right.length;
        int[] result = new int[count];
        while (count > 0) {
            if (leftIndex == left.length) {
                result[result.length - count--] = right[rightIndex++];
            } else if (rightIndex == right.length) {
                result[result.length - count--] = left[leftIndex++];
            } else {
                if (left[leftIndex] > right[rightIndex]) {
                    result[result.length - count--] = right[rightIndex++];
                } else {
                    result[result.length - count--] = left[leftIndex++];
                }
            }
        }
        return result;
    }

    private static int[] getRandomArray() {
        int l = R.nextInt(10);
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            result[i] = R.nextInt(10);
        }
        return result;
    }
}