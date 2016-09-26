package rmugattarov.generics;

/**
 * Created by rmugattarov on 26.09.2016.
 */
public class GenericsTest {
    public static void main(String[] args) {
        System.out.println(getCharSequence("Bazinga!"));
//        System.out.println(getCharSequence(new Object()));
    }

    private static <T extends CharSequence> T getCharSequence(T arg) {
        return arg;
    }
}
