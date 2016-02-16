package rmugattarov.filenet.ce;

import com.filenet.api.collection.AnnotationSet;
import com.filenet.api.core.*;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.UserContext;
import org.junit.Test;
import rmugattarov.filenet.ce.util.Connection_172_28_24_184;

import javax.security.auth.Subject;
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
            SearchSQL searchSQL = new SearchSQL("select AnnotatedObject from worklogrecord where annotatedobject={B4766756-D48A-4AAF-BEF7-B0B0FAE7B93E} AND " +
                    "((StepName = 'Автоматическое связывание' AND Response <> 'Успешно') OR " +
                    "(StepName = 'Ручное связывание' AND Response IS NULL))");
            AnnotationSet annotations = (AnnotationSet) searchScope.fetchObjects(searchSQL, null, null, true);
            Iterator<Annotation> iterator = annotations.iterator();
            int counter = 0;
            while (iterator.hasNext()) {
                Annotation annotation = iterator.next();
                System.out.printf("%d) %s\n", ++counter, annotation.get_AnnotatedObject().getProperties().getIdValue("Id").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
