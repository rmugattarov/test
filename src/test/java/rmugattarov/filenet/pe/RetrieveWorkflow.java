package rmugattarov.filenet.pe;

import com.filenet.api.constants.PropertyNames;
import filenet.vw.api.VWQueue;
import filenet.vw.api.VWSession;
import filenet.vw.api.VWWorkBasket;
import filenet.vw.api.VWWorkObject;
import org.junit.Test;

import java.util.Arrays;

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
            int filteredCount = basket.fetchFilteredCount(0, null, null, null, null, null, 1);
            System.out.println(filteredCount);
            VWWorkBasket.QueryResults queryResults = basket.fetchFilteredBatch(0, filteredCount, null, null, null, null, null, null, 1);
            VWWorkObject[] workObjects = (VWWorkObject[]) queryResults.getWorkObjects();
            int i = 0;
            for (VWWorkObject workObject : workObjects) {
                System.out.printf("%d) %s\n", ++i, workObject.getFieldValue("F_Subject"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            vwSession.logoff();
        }
    }
}
