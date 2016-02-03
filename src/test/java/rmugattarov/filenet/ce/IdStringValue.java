package rmugattarov.filenet.ce;

import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.core.*;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.UserContext;
import org.junit.Test;
import rmugattarov.filenet.ce.util.Connection_172_28_24_184;

import javax.security.auth.Subject;
import java.util.Iterator;

/**
 * Created by rmugattarov on 03.02.2016.
 */
public class IdStringValue {
    @Test
    public void test() {
        Connection connection = new Connection_172_28_24_184().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            SearchScope searchScope = new SearchScope(objectStore);
            SearchSQL searchSQL = new SearchSQL("SELECT TOP 1 Id FROM Folder");
            IndependentObjectSet objectSet = searchScope.fetchObjects(searchSQL, 1, null, false);
            Iterator iterator = objectSet.iterator();
            while (iterator.hasNext()) {
                Folder annotation = (Folder) iterator.next();
                System.out.println(annotation.getProperties().getIdValue("Id").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
