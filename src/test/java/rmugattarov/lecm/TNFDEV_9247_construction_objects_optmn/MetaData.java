package rmugattarov.lecm.TNFDEV_9247_construction_objects_optmn;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

/**
 * Created by rmugattarov on 09.02.2016.
 */
public class MetaData {
    private String host = "172.28.24.186";
    private String dbms = "db2";
    private String port = "50000";
    private String db = "REFDB182";

    @Test
    public void test() {
        Connection connection = null;
        PreparedStatement stmt = null;
        Properties connProperties = new Properties();
        connProperties.put("user", "refuser");
        connProperties.put("password", "o9p0[-]=");
        try {
            connection = DriverManager.getConnection("jdbc:" + dbms + "://" + host + ":" + port + "/" + db, connProperties);
            ResultSet columns = connection.getMetaData().getColumns(null, null, "CONSTRUCTIONOBJECTS", null);
            while (columns.next()) {
                System.out.printf("NAME : %s, SIZE : %d\n", columns.getString("COLUMN_NAME"), columns.getInt("COLUMN_SIZE"));
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
