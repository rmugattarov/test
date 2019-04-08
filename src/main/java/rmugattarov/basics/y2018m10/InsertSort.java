package rmugattarov.basics.y2018m10;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InsertSort {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int[] arr = getRandomArray();
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr.length < 2) return;
        int iters = 0;
        int swaps = 0;
        for (int i = 1; i < arr.length; i++) {
            iters++;
            System.out.println(Arrays.toString(arr));
            int j = i - 1;
            if (arr[j] <= arr[i]) {
                continue;
            }
            int temp = arr[i];
            while (j >= 0) {
                if (arr[j] <= arr[i]) {
                    swaps++;
                    shift(arr, j + 1, i - j - 1);
                    arr[j + 1] = temp;
                    break;
                }
                if (j == 0) {
                    swaps++;
                    shift(arr, 0, i);
                    arr[0] = temp;
                }
                j--;
            }

        }
        System.out.println("length: " + arr.length + ", iters: " + iters + ", swaps: " + swaps);
    }

    private static void shift(int[] arr, int start, int length) {
        while (length > 0) {
            int i = start + length--;
            arr[i] = arr[i - 1];
        }
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