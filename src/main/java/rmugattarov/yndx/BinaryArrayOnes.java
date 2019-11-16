package rmugattarov.yndx;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BinaryArrayOnes {
    private static final Random R = ThreadLocalRandom.current();
    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            int[] arr = getRandomBinaryArray();
            System.out.println(Arrays.toString(arr));
            int longestSeq = getLongetOnesSeq(arr);
            System.out.println(longestSeq);
        }
    }

    private static int getLongetOnesSeq(int[] arr) {
        int longestOnes = 0;
        int currentOnes = 0;
        for (int i: arr) {
            if(i == 1) {
                currentOnes++;
            } else if (currentOnes != 0) {
                longestOnes = Math.max(longestOnes, currentOnes);
                currentOnes = 0;
            }
        }
        longestOnes = Math.max(longestOnes, currentOnes);
        return longestOnes;
    }

    private static int[] getRandomBinaryArray() {
        int l = R.nextInt(10);
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            result[i] = R.nextInt(2);
        }
        return result;
    }
}
