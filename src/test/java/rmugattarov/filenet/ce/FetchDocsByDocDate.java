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
 * Created by rmugattarov on 26.02.2016.
 */
public class FetchDocsByDocDate {
    @Test
    public void test() {
        Connection connection = new Connection_172_28_24_184().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            SearchScope searchScope = new SearchScope(objectStore);
            SearchSQL searchSQL = new SearchSQL("SELECT Id FROM SZMNDocuments WHERE IsCurrentVersion=TRUE AND DocDate>=20160212T000000Z AND DocDate<=20160226T180000Z");
            IndependentObjectSet objectSet = searchScope.fetchObjects(searchSQL, 1, null, false);
            Iterator iterator = objectSet.iterator();
            int counter = 0;
            while (iterator.hasNext()) {
                Document annotation = (Document) iterator.next();
                System.out.printf("%d) %s\n", ++counter, annotation.getProperties().getIdValue("Id").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
