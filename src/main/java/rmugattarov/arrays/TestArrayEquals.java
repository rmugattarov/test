package rmugattarov.arrays;

import java.util.Arrays;

/**
 * Created by rmugattarov on 26.12.2016.
 */
public class TestArrayEquals {
    public static void main(String[] args) {
        int[] arr0 = new int[]{1, 2};
        int[] arr1 = new int[]{1, 2};
        System.out.println(Arrays.equals(arr0, arr1));
        System.out.println(arr0.equals(arr1));
    }
}
