package rmugattarov.core_java.regex;

import org.junit.Test;

/**
 * Created by rmugattarov on 05.05.2016.
 */
public class RandomRegex {
    @Test
    public void test() {
        System.out.println("TN/server:KISEHDCell_cpe-node01_Cpe_cluster_cpe-node01".matches("(?i)(server:.*)|(/UNAUTHENTICATED)|(defaultwimfilebasedrealm.*)|(TN/Server:KISEHDCell_cpe-node01_cpe_cluster_cpe-node01)"));
    }
}
