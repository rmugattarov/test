package rmugattarov.core_java.enums;

import org.junit.Test;

/**
 * Created by rmugattarov on 21.01.2016.
 */
public class IterateEnumValuesTest {
    enum Outcome {
        SUCCESSFUL(1),
        UNSUCCESSFUL(0),
        UNKNOWN(-1);

        private Integer asInt;

        Outcome(Integer asInt) {
            this.asInt = asInt;
        }

        public Integer asInt() {
            return asInt;
        }
    }

    @Test
    public void iterate() {
        for (Outcome outcome : Outcome.values()) {
            System.out.printf("outcome : %s\n", outcome);
        }
    }
}
