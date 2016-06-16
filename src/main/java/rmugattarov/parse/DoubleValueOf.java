package rmugattarov.parse;

/**
 * Created by rmugattarov on 16.06.2016.
 */
public class DoubleValueOf {
    public static void main(String[] args) {
        String s1 = "1.5";
        String s2 = "1,5";
        System.out.println(Double.valueOf(s1));
        System.out.println(Double.valueOf(s2));
    }
}
