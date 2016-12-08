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
        for (int i = idx.length - 1; i >= 0; i--) {
            if (idx[0] == len - idx.length) {
                break;
            }
            if (i == 0) {
                for (int j = 0; j < idx.length; j++) {
                    if (j == 0) {
                        idx[j] = idx[j] + 1;
                    } else {
                        idx[j] = idx[j - 1] + 1;
                    }
                }
                i = idx.length - 1;
                System.out.println(Arrays.toString(idx));
            } else {
                if (idx[i] + 1 > len) {
                    idx[i - 1] = idx[i - 1] + 1;
                    for (int j = i; j < idx.length; j++) {
                        idx[j] = idx[j - 1] + 1;
                    }
                    i = idx.length - 1;
                    System.out.println(Arrays.toString(idx));
                } else {
                    idx[i] = idx[i] + 1;
                    System.out.println(Arrays.toString(idx));
                }
            }
        }
    }
}
