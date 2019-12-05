package rmugattarov.fnly;

public class ReturnBeforeFnly {
    public static void main(String[] args) {
        m();
    }

    private static void m() {
        try {
            System.out.println(1);
            return;
        } finally {
            System.out.println(2);
        }
    }
}
