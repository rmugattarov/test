package rmugattarov.jdbc;

import org.junit.Test;

import java.sql.*;
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
        CallableStatement stmt = null;
        Properties connProperties = new Properties();
        connProperties.put("user", "refuser");
        connProperties.put("password", "o9p0[-]=");
        try {
            connection = DriverManager.getConnection("jdbc:" + dbms + "://" + host + ":" + port + "/" + db, connProperties);
            stmt = connection.prepareCall("call count_sec_audit(?)");
            stmt.registerOutParameter(1, Types.INTEGER);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                System.out.printf("Security audit count : %d", resultSet.getInt("count"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
