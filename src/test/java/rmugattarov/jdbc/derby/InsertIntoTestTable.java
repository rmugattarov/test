package rmugattarov.jdbc.derby;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rmugattarov on 28.01.2016.
 */
public class InsertIntoTestTable {
    @Test
    public void insert() {
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby:D:/derby-db");
            stmt = connection.createStatement();
            stmt.execute("insert into test_table(comment) values('second row')");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
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
