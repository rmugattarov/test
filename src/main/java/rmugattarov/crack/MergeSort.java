package rmugattarov.crack;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {

    private static final ThreadLocalRandom R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            System.out.println("Input arrays:");
            int[] randomIntArray = getRandomIntArray();
            System.out.println(Arrays.toString(randomIntArray));
            int[] dummyArray = {};
            int[] sortedArray = mergeSort(randomIntArray, dummyArray);
            System.out.println("Sorted:");
            System.out.println(Arrays.toString(sortedArray));
        }
    }

    private static int[] mergeSort(int[] left, int[] right) {
        if (left.length < 2 && right.length < 2) {
            return merge(left, right);
        }
        if (left.length < 2 && right.length > 2) {
            return merge(left, mergeSort(leftHalf(right), rightHalf(right)));
        }
        if (left.length > 2 && right.length < 2) {
            return merge(mergeSort(leftHalf(left), rightHalf(left)), right);
        }
        return merge(
                mergeSort(leftHalf(left), rightHalf(left)),
                mergeSort(leftHalf(right), rightHalf(right))
        );
    }

    private static int[] leftHalf(int[] arr) {
        return Arrays.copyOfRange(arr, 0, arr.length / 2);
    }

    private static int[] rightHalf(int[] arr) {
        return Arrays.copyOfRange(arr, arr.length / 2, arr.length);
    }

    private static int[] merge(int[] left, int[] right) {
        System.out.println("Merging : " + Arrays.toString(left) + " + " + Arrays.toString(right));
        if (left.length == 0) {
            System.out.println("Merged : " + Arrays.toString(right));
            return right;
        } else if (right.length == 0) {
            System.out.println("Merged : " + Arrays.toString(left));
            return left;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int count = left.length + right.length;
        int[] result = new int[count];
        for (; count > 0; count--) {
            if (leftIndex == left.length) {
                result[result.length - count] = right[rightIndex++];
            } else if (rightIndex == right.length) {
                result[result.length - count] = left[leftIndex++];
            } else {
                if (left[leftIndex] < right[rightIndex]) {
                    result[result.length - count] = left[leftIndex++];
                } else {
                    result[result.length - count] = right[rightIndex++];
                }
            }
        }
        System.out.println("Merged : " + Arrays.toString(result));
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
