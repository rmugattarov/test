package rmugattarov.core_java.enums;

import org.junit.Test;

/**
 * Created by rmugattarov on 19.01.2016.
 */
public class OrdinalTest {
    public enum A{
        A, B, C
    }
    @Test
    public void test() {
        System.out.printf("A.A.ordinal() : %d", A.A.ordinal());
    }
}
