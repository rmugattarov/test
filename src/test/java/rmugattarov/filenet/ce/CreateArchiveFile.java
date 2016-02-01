package rmugattarov.filenet.ce;

import com.filenet.api.constants.PropertyNames;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.*;
import com.filenet.api.property.Properties;
import com.filenet.api.util.UserContext;
import org.junit.Test;
import rmugattarov.filenet.ce.util.Connection_172_28_24_182;

import javax.security.auth.Subject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rmugattarov on 26.01.2016.
 */
public class CreateArchiveFile {

    private static class Timestamp {
        public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        @Override
        public String toString() {
            return "TNFDEV-9470-doc-blocking-" + (DATE_FORMAT.format(new Date()));
        }
    }

    @Test
    public void create_archive_file() {
        Connection connection = new Connection_172_28_24_182().getConnection();
        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
        UserContext.get().pushSubject(subject);
        try {
            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
            Folder testFolder = Factory.Folder.fetchInstance(objectStore, "/test/rmugattarov", null);

            Folder archiveFile = Factory.Folder.createInstance(objectStore, "ArchiveFile");

            Properties properties = archiveFile.getProperties();
            properties.putValue(PropertyNames.PARENT, testFolder);
            properties.putValue(PropertyNames.FOLDER_NAME, new Timestamp().toString());
            properties.putValue("DocflowYear", 2016);
            properties.putValue("DocflowIndex", new Timestamp().toString());
            properties.putValue("OArchiveFileName", new Timestamp().toString());
            properties.putValue("SavingType", 0);
            properties.putValue("ArticleNum", new Timestamp().toString());
            properties.putValue("SavingTime", 1);

            archiveFile.save(RefreshMode.REFRESH);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UserContext.get().popSubject();
        }
    }
}
