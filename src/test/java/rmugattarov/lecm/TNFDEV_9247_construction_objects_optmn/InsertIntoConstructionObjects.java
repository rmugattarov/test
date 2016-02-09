package rmugattarov.lecm.TNFDEV_9247_construction_objects_optmn;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by rmugattarov on 09.02.2016.
 */
public class InsertIntoConstructionObjects {
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
            stmt = connection.prepareStatement("INSERT INTO constructionobjects(agentcode,agentname,agentkod,agentabbr,parentagentcode) values(?,?,?,?,?)");
            for (int i = 0; i < 10000; i++) {
                stmt.setString(1, String.valueOf(i));
                stmt.setString(2, String.valueOf(i));
                stmt.setString(3, String.valueOf(i));
                stmt.setString(4, String.valueOf(i));
                stmt.setString(5, String.valueOf(i));
                stmt.addBatch();
            }
            stmt.executeBatch();
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
