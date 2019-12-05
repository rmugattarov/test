package rmugattarov.crack;

public class F0 {
    public static void main(String[] args) {
        System.out.println(f(0));
        System.out.println(f(1));
        System.out.println(f(2));
        System.out.println(f(3));
        System.out.println(f(4));
        System.out.println(f(5));
    }

    private static int f(int n) {
        if (n < 0) return 1;
        return f(n - 1) + f(n - 1);
    }
}
