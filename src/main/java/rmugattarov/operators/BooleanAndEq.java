package rmugattarov.operators;

/**
 * Created by rmugattarov on 23.05.2017.
 */
public class BooleanAndEq {
    public static void main(String[] args) {
        boolean b = true;
        boolean arr[] = {true, true, false};
        System.out.println(b);
        for (boolean x: arr) {
            b &= x;
            System.out.println(b);
        }
        System.out.println(b);
    }
}
