package rmugattarov.math;

import java.math.BigInteger;
import java.util.Arrays;

public class BigIntQuotAndRemain {
    public static void main(String[] args) {
        int val = 100;
        System.out.println(Arrays.toString(BigInteger.valueOf(val).divideAndRemainder(BigInteger.valueOf(33))));
    }
}
