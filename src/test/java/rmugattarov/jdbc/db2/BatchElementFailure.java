package rmugattarov.jdbc.db2;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Created by rmugattarov on 31.03.2016.
 */
public class BatchElementFailure {
    private String host = "172.28.24.186";
    private String dbms = "db2";
    private String port = "50000";
    private String db = "REFDB182";
    private Random rand = new Random();

    @Test
    public void test() throws SQLException {
        java.util.Properties connProperties = new java.util.Properties();
        connProperties.put("user", "refuser");
        connProperties.put("password", "o9p0[-]=");
        try (java.sql.Connection connection = DriverManager.getConnection("jdbc:" + dbms + "://" + host + ":" + port + "/" + db, connProperties); PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO login_audit(login,login_time,last_action_time, result,ip) VALUES(?,?,?,?,?)"
        )) {
            setPsParams(stmt, "dummy_login", new Timestamp(0L), new Timestamp(0L), 0, "dummy_ip");
            stmt.addBatch();
            setPsParams(stmt, "dummy_" + Math.random(), new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()), rand.nextInt(), "dummy_" + Math.random() + "");
            stmt.addBatch();
            setPsParams(stmt, "dummy_login", new Timestamp(0L), new Timestamp(0L), 0, "dummy_ip");
            stmt.addBatch();
            setPsParams(stmt, "dummy_" + Math.random(), new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()), rand.nextInt(), "dummy_" + Math.random() + "");
            stmt.addBatch();
            setPsParams(stmt, "dummy_" + Math.random(), new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()), rand.nextInt(), "dummy_" + Math.random() + "");
            stmt.addBatch();
            System.out.println(Arrays.toString(stmt.executeBatch()));
            System.out.println("DONE");
        }
    }

    private void setPsParams(PreparedStatement stmt, String login, Timestamp login_time, Timestamp lastActionTime, Integer result, String ip) throws SQLException {
        stmt.setString(1, login);
        stmt.setTimestamp(2, login_time);
        stmt.setTimestamp(3, lastActionTime);
        stmt.setInt(4, result);
        stmt.setString(5, ip);
    }
}
