package rmugattarov.enums;

/**
 * Created by rmugattarov on 26.12.2016.
 */
public class TestEnumOrdinal {
    public enum A {
        A, B, C
    }

    public static void main(String[] args) {
        for (A a : A.values()) {
            System.out.println(a.ordinal());
        }
    }
}
