package rmugattarov.inplacesort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortInPlace {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            byte[] randomArray = getRandomArray();
            System.out.println(Arrays.toString(randomArray));
            byte[] aux = new byte[randomArray.length];
//            sort(randomArray, aux, 0, randomArray.length);
            System.out.println(Arrays.toString(aux));
        }
    }


    private static byte[] getRandomArray() {
        int len = R.nextInt(16);
        byte[] res = new byte[len];
        for (int i = 0; i < len; i++) {
            res[i] = (byte) R.nextInt(101);
        }
        return res;
    }
}
