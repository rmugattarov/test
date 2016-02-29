package rmugattarov.core_java;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rmugattarov on 29.02.2016.
 */
public class VarArg {
    @Test
    public void test() {
        varArgMeth("1", "2");
    }

    private void varArgMeth(String p1, String... args) {
        System.out.printf(p1 + " " + Arrays.asList(args));
    }
}
