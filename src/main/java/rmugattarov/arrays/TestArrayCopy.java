package rmugattarov.arrays;

import java.util.Arrays;

/**
 * Created by rmugattarov on 14.12.2016.
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3};
        int[] copy = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(copy));
        copy[1] = 5;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(copy));
    }
}
