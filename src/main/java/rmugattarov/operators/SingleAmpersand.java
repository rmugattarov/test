package rmugattarov.operators;

/**
 * Created by rmugattarov on 23.05.2017.
 */
public class SingleAmpersand {
    public static void main(String[] args) {
        System.out.println(f() && t());
        System.out.println("===");
        System.out.println(f() & t());
    }

    public static boolean t() {
        System.out.println("t");
        return true;
    }

    public static boolean f() {
        System.out.println("f");
        return false;
    }
}
