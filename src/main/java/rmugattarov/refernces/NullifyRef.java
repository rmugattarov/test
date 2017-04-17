package rmugattarov.refernces;

/**
 * Created by rmugattarov on 17.04.2017.
 */
public class NullifyRef {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s);
        nullifeyRef(s);
        System.out.println(s);
    }

    private static void nullifeyRef(Object o) {
        o = null;
    }
}
