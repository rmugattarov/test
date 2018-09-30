package rmugattarov.crack;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    private static final ThreadLocalRandom R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        System.out.println("Input array:");
        int[] randomIntArray = getRandomIntArray();
        System.out.println(Arrays.toString(randomIntArray));
        int[] sortedArray = quickSort(randomIntArray);
        System.out.println("Sorted:");
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] quickSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        if (arr.length < 2) {
            return arr;
        }
        int pivotIndex = arr.length / 2;
        int pivot = arr[pivotIndex];
        int smallerCounter = 0;
        int greaterCounter = 0;
        int[] smaller = new int[arr.length];
        int[] greater = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == pivotIndex) {
                continue;
            }
            if (arr[i] > pivot) {
                greater[greaterCounter++] = arr[i];
            } else {
                smaller[smallerCounter++] = arr[i];
            }
        }
        smaller = Arrays.copyOfRange(smaller, 0, smallerCounter);
        greater = Arrays.copyOfRange(greater, 0, greaterCounter);
        System.out.println("Smaller: " + Arrays.toString(smaller) + " + Pivot: " + pivot + " + Greater: " + Arrays.toString(greater));
        return merge(quickSort(smaller), pivot, quickSort(greater));
    }

    private static int[] merge(int[] smaller, int pivot, int[] greater) {
        int[] result = new int[smaller.length + 1 + greater.length];
        System.arraycopy(smaller, 0, result, 0, smaller.length);
        result[smaller.length] = pivot;
        System.arraycopy(greater, 0, result, smaller.length + 1, greater.length);
        return result;
    }

    private static int[] getRandomIntArray() {
        int l = R.nextInt(20);
        int[] result = new int[l];
        for (int i = 0; i < result.length; i++) {
            result[i] = R.nextInt(10);
        }
        return result;
    }
}
