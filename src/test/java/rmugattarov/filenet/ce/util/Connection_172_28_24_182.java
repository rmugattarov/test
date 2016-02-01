package rmugattarov.filenet.ce.util;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Factory;

/**
 * Created by rmugattarov on 26.01.2016.
 */
public class Connection_172_28_24_182 {
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            this.connection = Factory.Connection.getConnection("http://172.28.24.182:9080/wsi/FNCEWS40MTOM/");
        }
        return connection;
    }
}
