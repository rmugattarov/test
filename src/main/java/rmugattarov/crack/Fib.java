package rmugattarov.crack;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Fib {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int n = R.nextInt(10);
        System.out.println("Fib of " + n + " is " + fib(n));
    }

    private static int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
