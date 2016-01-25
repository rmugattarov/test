package rmugattarov.core_java.enums;

import org.junit.Test;

/**
 * Created by rmugattarov on 25.01.2016.
 */
public class EmtyStringToStringTest {

    public enum TestEnum {
        A(""), B(""), C("CCC");

        private final String stringValue;

        private TestEnum(String s) {
            this.stringValue = s;
        }
    }

    @Test
    public void test() {
        for (TestEnum enumVal : TestEnum.values()) {
            System.out.printf("'%s'\n", enumVal);
        }
    }
}
