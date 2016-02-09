package rmugattarov.core_java;

import com.filenet.api.util.Id;
import org.junit.Test;

/**
 * Created by rmugattarov on 09.02.2016.
 */
public class Hex {
    @Test
    public void test() {
        Id id = new Id("{980A53A6-798D-49FA-8035-670C208B5DE3}");
        System.out.println(org.apache.commons.codec.binary.Hex.encodeHex(id.getBytes(), false));
    }
}
