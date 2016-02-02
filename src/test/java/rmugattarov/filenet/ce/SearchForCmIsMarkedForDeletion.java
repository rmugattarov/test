package rmugattarov.filenet.ce;

import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.core.*;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.UserContext;
import org.junit.Test;
import rmugattarov.filenet.ce.util.Connection_172_28_24_182;

import javax.security.auth.Subject;
import java.util.Iterator;

/**
 * Created by rmugattarov on 28.01.2016.
 */
public class SearchForCmIsMarkedForDeletion {
    @Test
    public void test() {
        Connection connection = new Connection_172_28_24_182().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            SearchScope searchScope = new SearchScope(objectStore);
            SearchSQL searchSQL = new SearchSQL("SELECT TOP 1000 CmIsMarkedForDeletion FROM Document");
            IndependentObjectSet objectSet = searchScope.fetchObjects(searchSQL, 1000, null, false);
            Iterator iterator = objectSet.iterator();
            int isMarked = 0;
            int isNotMarked = 0;
            while (iterator.hasNext()) {
                Document document = (Document) iterator.next();
                Boolean cmIsMarkedForDeletion = document.getProperties().getBooleanValue("CmIsMarkedForDeletion");
                if (cmIsMarkedForDeletion) {
                    isMarked++;
                } else {
                    isNotMarked++;
                }
            }
            System.out.printf("isMarked : %d\nisNotMarked : %d\n", isMarked, isNotMarked);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
