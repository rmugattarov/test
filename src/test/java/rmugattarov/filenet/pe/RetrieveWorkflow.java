package rmugattarov.filenet.pe;

import filenet.vw.api.VWQueue;
import filenet.vw.api.VWSession;
import filenet.vw.api.VWWorkBasket;
import org.junit.Test;

/**
 * Created by rmugattarov on 01.02.2016.
 */
public class RetrieveWorkflow {
    @Test
    public void test() {
        VWSession vwSession = new VWSession();
        try {
            vwSession = new VWSession();
            vwSession.setBootstrapCEURI("http://172.28.24.184:9080/wsi/FNCEWS40MTOM/");
            vwSession.logon("cpe_bootstrap@tn.fntst.ru", "o9p0[-]=", "CP01");
            VWQueue docQueue = vwSession.getQueue("DocQueue");
            VWWorkBasket basket = docQueue.fetchWorkBasket("Связывание с Заголовком дела");
            System.out.println(basket.getName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            vwSession.logoff();
        }
    }
}
