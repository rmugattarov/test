package rmugattarov.crack;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bitwise {

    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int input = R.nextInt(20);
            System.out.println("Halving: " + input);
            System.out.println("Ans: " + halve(input));
        }

        for (int i = 0; i < 3; i++) {
            int input = R.nextInt(20);
            System.out.println("Doubling: " + input);
            System.out.println("Ans: " + duble(input));
        }
    }
    private static int halve(int i) {
        return i >> 1;
    }

    private static int duble(int i) {
        return i << 1;
    }
}
