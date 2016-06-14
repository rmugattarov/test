package rmugattarov.memory;

/**
 * Created by rmugattarov on 14.06.2016.
 */
public class TestLoad {
    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < 1000000; i++) {
            System.out.println("MaxM : " + Runtime.getRuntime().maxMemory());
            System.out.println("FreeM : " + Runtime.getRuntime().freeMemory());
            System.out.println("Threads : " + Thread.activeCount());
            s += i;
        }
    }
}
