package rmugattarov.bad_interview;

public class No3 {
    public static void main(String[] args) {
        byte b = 1;
        action(b, b);
    }

    static void action(byte...b) {
        System.out.println("vararg");
    }
    static void action(long l1, short s1) {
        System.out.println("long short");
    }
    static void action(Byte b1, Byte b2) {
        System.out.println("boxed");
    }
}
