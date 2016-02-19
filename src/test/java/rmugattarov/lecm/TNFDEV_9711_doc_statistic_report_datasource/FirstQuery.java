package rmugattarov.lecm.TNFDEV_9711_doc_statistic_report_datasource;

import com.filenet.api.util.Id;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by rmugattarov on 19.02.2016.
 */
public class FirstQuery {
    private String host = "172.28.24.186";
    private String dbms = "db2";
    private String port = "50000";
    private String db = "OSDB182";

    @Test
    public void test() {
        java.sql.Connection connection = null;
        CallableStatement stmt = null;
        Properties connProperties = new Properties();
        connProperties.put("user", "os1user");
        connProperties.put("password", "o9p0[-]=");
        List<Id> ids = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:" + dbms + "://" + host + ":" + port + "/" + db, connProperties);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT DISTINCT c.OBJECT_ID " +
                            "FROM DOCVERSION d " +
                            "INNER JOIN RELATIONSHIP r ON r.HEAD_ID = d.OBJECT_ID " +
                            "INNER JOIN CONTAINER c ON c.OBJECT_ID = r.TAIL_ID " +
                            "WHERE " +
                            "(d.IS_CURRENT = 1) " +
                            "AND (d.U11E3_DOCDATE > (CURRENT date - 14 days) AND d.U11E3_DOCDATE < CURRENT date) " +
                            "AND (c.UB8A8_FOLDERSTATUS = 'Введен' OR (c.UB233_PACKSTATECHANGEDATE > (CURRENT date - 14 days) AND c.UB233_PACKSTATECHANGEDATE < CURRENT date))");

            int count = 0;
            while (resultSet.next()) {
                Id id = new Id(resultSet.getBytes("OBJECT_ID"));
                ids.add(id);
                System.out.printf("%d) %s\n", ++count, id);
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

//        Connection connection = new Connection_172_28_24_184().getConnection();
//        Subject subject = UserContext.createSubject(connection, "rmugattarov@tn.fntst.ru", "o9p0[-]=", null);
//        UserContext.get().pushSubject(subject);
//        try {
//            Domain domain = Factory.Domain.fetchInstance(connection, null, null);
//            ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "OST", null);
//            SearchScope searchScope = new SearchScope(objectStore);
//            SearchSQL searchSQL = new SearchSQL("select distinct newstatus from PackChangeHistory");
//            RepositoryRowSet repositoryRowSet = searchScope.fetchRows(searchSQL, null, null, true);
//            Iterator iterator = repositoryRowSet.iterator();
//            while (iterator.hasNext()) {
//                RepositoryRow row = (RepositoryRow) iterator.next();
//                String docStatus = row.getProperties().getStringValue("NewStatus");
//                System.out.println(docStatus);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            UserContext.get().popSubject();
//        }
    }
}
