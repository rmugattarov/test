package rmugattarov.enums;

/**
 * Created by rmugattarov on 15.09.2016.
 */
public class EnumEquality {
    enum A {
        A, B, C
    }

    public static void main(String[] args) {
        EnumEquality.A a1 = null;
        EnumEquality.A a2 = null;

        System.out.println(a1 == a2);

        a1 = A.A;
        a2 = A.A;

        System.out.println(a1 == a2);
        System.out.println(null == null);
    }
}
