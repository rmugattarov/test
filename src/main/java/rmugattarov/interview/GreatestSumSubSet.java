package rmugattarov.interview;

import java.util.Arrays;

public class GreatestSumSubSet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findGreatestSumSubSet(new int[]{8, 5, -3, -4, 1, 8, -1, 2, -3, 9, 5, 4})));
    }

    private static int[] findGreatestSumSubSet(int[] arr) {
        int start = 0;
        int end = 0;
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            current += arr[i];
            if (current < 0) {
                current = 0;
                start = i + 1;
            } else {
                end = i + 1;
                if (current > max) {
                    maxStart = start;
                    maxEnd = end;
                    max = current;
                }
            }
        }
        System.out.println("start " + start);
        System.out.println("end " + end);
        System.out.println("current " + current);
        System.out.println("maxStart " + maxStart);
        System.out.println("maxEnd " + maxEnd);
        System.out.println("max " + max);

        return Arrays.copyOfRange(arr, maxStart, maxEnd);
    }
}
