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
 * Created by rmugattarov on 02.02.2016.
 */
public class SearchForLinkArchiveAnnotations {
    @Test
    public void test() {
        Connection connection = new Connection_172_28_24_184().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            SearchScope searchScope = new SearchScope(objectStore);
            SearchSQL searchSQL = new SearchSQL("SELECT LinkArchType,LinkArchStatus,Id FROM LinkArchive WHERE AnnotatedObject = {FECFE222-2165-4264-A24A-BF3DE2790F1E}"
                    + " AND LOWER(LinkArchType) = 'ручное'" +
                    "AND LOWER(LinkArchStatus) = 'отменено'");
            IndependentObjectSet objectSet = searchScope.fetchObjects(searchSQL, 1000, null, false);
            Iterator iterator = objectSet.iterator();
            while (iterator.hasNext()) {
                Annotation annotation = (Annotation) iterator.next();
                System.out.println(annotation.getProperties().getStringValue("LinkArchType"));
                System.out.println(annotation.getProperties().getStringValue("LinkArchStatus"));
                System.out.println(annotation.getProperties().getIdValue("Id").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
