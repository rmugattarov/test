package rmugattarov.jdbc.derby;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rmugattarov on 28.01.2016.
 */
public class CreateTestTable {
    @Test
    public void create_test_table() {
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby:D:/derby-db");
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE test_table(id bigint generated always as identity, comment varchar(128))");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
