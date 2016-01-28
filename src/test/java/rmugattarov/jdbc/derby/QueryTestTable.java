package rmugattarov.jdbc.derby;

import org.junit.Test;

import java.sql.*;
import java.util.LinkedHashSet;

/**
 * Created by rmugattarov on 28.01.2016.
 */
public class QueryTestTable {
    @Test
    public void query() {
        Connection connection = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby:D:/derby-db");
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM test_table");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            LinkedHashSet<String> columnNames = new LinkedHashSet<>();
            for (int i = 1; i < columnCount + 1; i++) {
                System.out.printf("================================================");
                columnNames.add(metaData.getColumnName(i));
            }
            System.out.println("=");

            for (String columnName : columnNames) {
                System.out.printf("|%47s", columnName);
            }
            System.out.println("|");
            for (int i = 1; i < columnCount + 1; i++) {
                System.out.printf("================================================");
                columnNames.add(metaData.getColumnName(i));
            }
            System.out.println("=");

            while (resultSet.next()) {
                for (int i = 1; i < columnCount + 1; i++) {
                    String string = resultSet.getObject(i).toString();
                    System.out.printf("|%47s", string);
                }
            }
            System.out.println("|");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
