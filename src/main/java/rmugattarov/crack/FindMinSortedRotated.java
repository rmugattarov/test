package rmugattarov.crack;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class FindMinSortedRotated {

    private static final ThreadLocalRandom R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Input array:");
            int[] arr = createRandomSortedRotatedArray();
            System.out.println(Arrays.toString(arr));
            System.out.println("Min value:");
            System.out.println(findMinInSortedRotatedArray(arr, 0, arr.length));
        }
    }

    private static int findMinInSortedRotatedArray(int[] arr, int from, int to) {
        if (arr[from] < arr[to - 1]) {
            return arr[from];
        }
        int subArrLength = to - from;
        if (subArrLength == 1) {
            return arr[from];
        } else if (subArrLength == 2) {
            return Math.min(arr[from], arr[to - 1]);
        }
        int first = arr[from];
        int midIndex = (from + to) / 2;
        int mid = arr[midIndex];
        if (mid >= first) {
            return findMinInSortedRotatedArray(arr, midIndex + 1, to);
        } else {
            return findMinInSortedRotatedArray(arr, from, midIndex + 1);
        }
    }

    private static int[] createRandomSortedRotatedArray() {
        int l = R.nextInt(1, 20);
        int[] sorted = new int[l];
        for (int i = 0; i < l; i++) {
            sorted[i] = R.nextInt(10);
        }
        Arrays.sort(sorted);
        int[] rotated = new int[l];
        int offset = R.nextInt(l);
        for (int i = 0; i < offset; i++) {
            rotated[(offset + i) % l] = sorted[i];
        }
        for (int i = offset; i < l; i++) {
            rotated[(offset + i) % l] = sorted[i];
        }
        return rotated;
    }
}
