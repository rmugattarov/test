package rmugattarov.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rmugattarov on 18.06.2016.
 */
public class TestInMemoryH2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
        connection.prepareStatement("CREATE TABLE TEST_TABLE (ID BIGINT GENERATED ALWAYS AS IDENTITY, TEXT VARCHAR(32))").execute();
        connection.prepareStatement("INSERT INTO TEST_TABLE (TEXT) VALUES ('hello')").execute();
        connection.prepareStatement("INSERT INTO TEST_TABLE (TEXT) VALUES ('world')").execute();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM TEST_TABLE");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2));
        }
    }
}
