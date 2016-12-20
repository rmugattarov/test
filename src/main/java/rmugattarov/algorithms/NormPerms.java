package rmugattarov.algorithms;

import java.util.Arrays;

/**
 * Created by rmugattarov on 20.12.2016.
 */
public class NormPerms {
    public static void main(String[] args) {
        int[] idx = {0, 1, 2};
        norm(idx, 9);
        System.out.println(Arrays.toString(idx));
    }

    private static void norm(int[] idx, int len) {
        int countdown = len;
        while (countdown > 0) {
            for (int i = idx.length - 1; i > 0; i--) {
                if (i == idx.length - 1) {
                    idx[i] = idx[i] + 1;
                    countdown--;
                } else {
                    int leftDiff = idx[i] - idx[i - 1];
                    int rightDiff = idx[i + 1] - idx[i];
                    if (leftDiff + 1 < rightDiff) {
                        idx[i] = idx[i] + 1;
                        countdown--;
                    }
                }
            }
        }
        int offset = (len + idx.length - 1 - idx[idx.length - 1]) / 2;
        for (int i = 0; i < idx.length; i++) {
            idx[i] = idx[i] + offset;
        }
    }
}
