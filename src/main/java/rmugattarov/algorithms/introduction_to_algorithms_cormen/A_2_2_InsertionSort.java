package rmugattarov.algorithms.introduction_to_algorithms_cormen;

import java.util.Arrays;

/**
 * Created by rmugattarov on 11.01.2017.
 */
public class A_2_2_InsertionSort {
    public static void main(String[] args) {
        int[] ints = {3, 4, 2, 5, 1};
        System.out.printf("ints : %s\r\n", Arrays.toString(ints));

        int outerLoop = 0;
        int innerLoop = 0;
        for (int j = 1; j < ints.length; j++) {
            outerLoop++;
            int key = ints[j];
            int i = j - 1;
            while (i >= 0 && ints[i] > key) {
                innerLoop++;
                ints[i + 1] = ints[i];
                i = i - 1;
            }
            ints[i + 1] = key;
            System.out.printf("ints : %s\r\n", Arrays.toString(ints));
        }

        System.out.printf("Outer loop : %d\r\n", outerLoop);
        System.out.printf("Inner loop : %d\r\n", innerLoop);
        System.out.printf("ints : %s\r\n", Arrays.toString(ints));
    }
}
