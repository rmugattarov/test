package rmugattarov.switch_test;

/**
 * Created by rmugattarov on 06.10.2016.
 */
public class SwitchNull {
    public static void main(String[] args) {
        String s = null;
        switch (s) {
            default:
                System.out.println("default");
        }
        System.out.println("end");
    }
}
