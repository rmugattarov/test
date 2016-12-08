package rmugattarov.algorithms;

import java.util.Arrays;

/**
 * Created by rmugattarov on 08.12.2016.
 */
public class CombinationExtr {
    public static void main(String[] args) {
        int len = 5;
        int[] idx = new int[]{0, 1, 2};
        System.out.println(Arrays.toString(idx));
        int last = idx.length - 1;
        while (idx[0] <= len - idx.length) {
            idx[last] = idx[last] + 1;
            if (idx[last] > len) {
                raise(idx, last - 1, len);
                System.out.println(Arrays.toString(idx));
            } else {
                System.out.println(Arrays.toString(idx));
            }
        }
    }

    private static void raise(int[] idx, int i, int len) {
        idx[i] = idx[i] + 1;
        if (idx[i] > len) {
            raise(idx, i - 1, len);
        } else {
            for (int j = i + 1; j < idx.length; j++) {
                idx[j] = idx[j - 1] + 1;
            }
        }
    }

}
