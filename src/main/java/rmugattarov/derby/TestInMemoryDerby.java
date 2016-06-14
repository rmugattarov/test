package rmugattarov.derby;

import java.sql.*;

/**
 * Created by rmugattarov on 14.06.2016.
 */
public class TestInMemoryDerby {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        Connection connection = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true");
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE TEST_TABLE (ID BIGINT GENERATED ALWAYS AS IDENTITY, TEXT VARCHAR(32))");
        statement.executeUpdate("INSERT INTO TEST_TABLE (TEXT) VALUES ('hello')");
        statement.executeUpdate("INSERT INTO TEST_TABLE (TEXT) VALUES ('world')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST_TABLE");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2));
        }
    }
}
