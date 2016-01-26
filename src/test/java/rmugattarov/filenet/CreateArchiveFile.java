package rmugattarov.filenet;

import com.filenet.api.core.*;
import com.filenet.api.util.UserContext;
import org.junit.Test;

import javax.security.auth.Subject;

/**
 * Created by rmugattarov on 26.01.2016.
 */
public class CreateArchiveFile {
    @Test
    public void create_archive_file() {
        Connection connection = new Connection_172_28_24_182().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            Folder folder = Factory.Folder.fetchInstance(objectStore, "/test/rmugattarov", null);
            System.out.println(folder);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
