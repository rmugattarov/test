package rmugattarov.filenet.ce;

import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.core.*;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.UserContext;
import org.junit.Test;
import rmugattarov.filenet.ce.util.Connection_172_28_24_184;

import javax.security.auth.Subject;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by rmugattarov on 16.02.2016.
 */
public class QueryWorkLogRecordAnnotations {
    @Test
    public void test() {
        Connection connection = new Connection_172_28_24_184().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            SearchScope searchScope = new SearchScope(objectStore);
            SearchSQL searchSQL = new SearchSQL("select annotatedobject from worklogrecord where annotatedobject={37224497-31FC-470C-8E68-7A970F7111E0}");
            IndependentObjectSet objectSet = searchScope.fetchObjects(searchSQL, null, null, true);
            Annotation annotation = (Annotation) objectSet.iterator().next();
            System.out.printf("%s", annotation.get_AnnotatedObject().getProperties().getIdValue("Id").toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
