package rmugattarov.bad_interview;

class Test {
    static {
        if(true) throw new NullPointerException();
    }

    public static void run() {
        System.out.println("running");
    }
}

public class No12 {
    public static void main(String[] args) {
        try {
            Test.run();
        } catch (Throwable t) {
            Test.run();
        }
    }

}
