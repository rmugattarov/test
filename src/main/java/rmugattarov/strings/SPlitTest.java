package rmugattarov.strings;

/**
 * Created by rmugattarov on 09.08.2016.
 */
public class SplitTest {
    public static void main(String[] args) {
        System.out.println("1=".split("=").length);
        System.out.println("1=".split("=", 0).length);
        System.out.println("1=".split("=", 1).length);
        System.out.println("1=".split("=", 2).length);
        System.out.println("1=".split("=", 3).length);
    }
}
