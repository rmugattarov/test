package rmugattarov.y2019m12;

import org.apache.commons.lang3.RandomUtils;
import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] randomArray = RandomUtil.getRandomSortedArray();
        int val = RandomUtils.nextInt(0, 17);
        System.out.println(Arrays.toString(randomArray));
        System.out.println(val);
        int index = binarySearch(randomArray, val);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int val) {
        if (arr.length < 1) return -1;
        return binarySearch(arr, val, 0, arr.length);
    }

    private static int binarySearch(int[] arr, int val, int from, int to) {
        if (to - from < 1) return -1;
        int mid = (from + to) / 2;
        if (arr[mid] == val) return mid;
        else if (arr[mid] < val) return binarySearch(arr, val, mid + 1, to);
        return binarySearch(arr, val, from, mid);
    }
}
