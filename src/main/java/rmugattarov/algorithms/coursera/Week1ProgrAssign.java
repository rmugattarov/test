package rmugattarov.algorithms.coursera;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmugattarov on 13.01.2017.
 */
public class Week1ProgrAssign {
    public static void main(String[] args) {
        String leftNumber = "3141592653589793238462643383279502884197169399375105820974944592";
        String rightNumber = "2718281828459045235360287471352662497757247093699959574966967627";
        char[] left = leftNumber.toCharArray();
        char[] right = rightNumber.toCharArray();
        List<String> lineProducts = new ArrayList<>();


        for (int i = right.length - 1; i >= 0; i--) {
            char r = right[i];
            int carry = 0;
            String lineProduct = "";
            for (int j = left.length - 1; j >= 0; j--) {
                char l = left[j];
                int product = (Integer.valueOf("" + l) * Integer.valueOf("" + r)) + carry;
                System.out.println("carry before : " + carry);
                System.out.println(r + " * " + l);
                System.out.println("product : " + product);
                if (product > 9) {
                    carry = product / 10;
                } else {
                    carry = 0;
                }
                System.out.println("carry : " + carry);
                lineProduct = (j == 0 ? product : product % 10) + lineProduct;
            }
            lineProducts.add(lineProduct);
        }
        BigInteger result = BigInteger.ZERO;
        System.out.println(lineProducts);
        System.out.println(lineProducts.size());
        for (int i = 0; i < lineProducts.size(); i++) {
            BigInteger lineProduct = new BigInteger(lineProducts.get(i));
            BigInteger paddingFactor = BigInteger.ONE;
            for (int j = 1; j <= i; j++) {
                paddingFactor = paddingFactor.multiply(BigInteger.TEN);
            }
            lineProduct = lineProduct.multiply(paddingFactor);
            result = result.add(lineProduct);
        }
        System.out.printf("%s\r\n", result);
        BigInteger validation = new BigInteger(leftNumber).multiply(new BigInteger(rightNumber));
        System.out.printf("%s\r\n", validation);
        System.out.println(validation.equals(result));
    }
}
