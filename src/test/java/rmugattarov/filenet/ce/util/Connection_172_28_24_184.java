package rmugattarov.filenet.ce.util;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Factory;

/**
 * Created by rmugattarov on 02.02.2016.
 */
public class Connection_172_28_24_184 {
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            this.connection = Factory.Connection.getConnection("http://172.28.24.184:9080/wsi/FNCEWS40MTOM/");
        }
        return connection;
    }
}
