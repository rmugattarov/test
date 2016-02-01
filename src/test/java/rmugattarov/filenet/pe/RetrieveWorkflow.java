package rmugattarov.filenet.pe;

import filenet.vw.api.VWSession;
import org.junit.Test;

/**
 * Created by rmugattarov on 01.02.2016.
 */
public class RetrieveWorkflow {
    @Test
    public void test() {
        VWSession vwSession = new VWSession();
        vwSession.setBootstrapCEURI("http://172.28.24.184:9080/wsi/FNCEWS40MTOM/");
        vwSession.logon("cpe_bootstrap@tn.fntst.ru", "o9p0[-]=", "CP01");
        System.out.println(vwSession.getObjectStoreSymbolicName());
        vwSession.logoff();
    }
}
