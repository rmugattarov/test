package rmugattarov.bad_interview;

public class No7 {
    public static void main(String[] args) {
        new No7().work();
    }

    private void work() {
        try {
            work();
        } finally {
            work();
        }
    }
}
