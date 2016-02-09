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
 * Created by rmugattarov on 09.02.2016.
 */
public class QueryInfolder {
    @Test
    public void test() {
        Connection connection = new Connection_172_28_24_184().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            Folder folder = Factory.Folder.fetchInstance(objectStore, "/Справочники/Объекты строительства", null);
            System.out.println(folder.get_Id());
            SearchScope searchScope = new SearchScope(objectStore);
            SearchSQL searchSQL = new SearchSQL("select id from katstroy with excludesubclasses where iscurrentversion=true and this infolder '/Справочники/Объекты строительства' and iscatalogelementactive is not null");
            System.out.println(new Date());
            IndependentObjectSet objectSet = searchScope.fetchObjects(searchSQL, null, null, true);
            Iterator iterator = objectSet.iterator();
            int counter = 0;
            while (iterator.hasNext()) {
                counter++;
            }
            System.out.println(new Date());
            System.out.printf("counter : %d\n", counter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
