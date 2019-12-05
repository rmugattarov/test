package rmugattarov.tricks;

import java.util.Random;

public class SwapInPlace {
    public static void main(String[] args) {
        Random r = new Random();
        int a = r.nextInt(Short.MAX_VALUE);
        int b = r.nextInt(Short.MAX_VALUE);
        System.out.println(a + " : " + b);
        a = a << 16;
        a = a ^ b;
        b = a;
        b = b >> 16;
        a = a << 16;
        a = a >> 16;
        System.out.println(a + " : " + b);
    }
}
