package rmugattarov.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by rmugattarov on 26.01.2016.
 */
public class CallStoredProcedure {
    private String host = "172.28.24.186";
    private String dbms = "db2";
    private String port = "50000";
    private String db = "REFDB182";

    @Test
    public void connect_and_call_stored_procedure() {
        Connection connection = null;
        Properties connProperties = new Properties();
        connProperties.put("user", "refuser");
        connProperties.put("password", "o9p0[-]=");
        try {
            connection = DriverManager.getConnection("jdbc:" + dbms + "://" + host + ":" + port + "/" + db, connProperties);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(connection);
    }
}
