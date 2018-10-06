package rmugattarov.basics.y2018m10;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int[] randomArray = getRandomArray();
        System.out.println(Arrays.toString(randomArray));
        int[] sorted = sort(randomArray);
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] sort(int[] arr) {
        if (arr.length < 2) return arr;
        int pivotIndex = arr.length / 2;
        int pivot = arr[pivotIndex];
        int[] lesser = new int[arr.length];
        int[] greater = new int[arr.length];
        int lesserCount = 0;
        int greaterCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == pivotIndex) continue;
            if (arr[i] > pivot) {
                greater[greaterCount++] = arr[i];
            } else {
                lesser[lesserCount++] = arr[i];
            }
        }
        lesser = Arrays.copyOfRange(lesser, 0, lesserCount);
        greater = Arrays.copyOfRange(greater, 0, greaterCount);
        return merge(sort(lesser), pivot, sort(greater));
    }

    private static int[] merge(int[] left, int pivot, int[] right) {
        int[] result = new int[left.length + 1 + right.length];
        System.arraycopy(left, 0, result, 0, left.length);
        result[left.length] = pivot;
        System.arraycopy(right, 0, result, left.length + 1, right.length);
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