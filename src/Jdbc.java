import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
public class Jdbc {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
        String username = "sa";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "update Hotel set Hstarrating=5 where Hid=2";
        Statement stmt=conn.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println(count);
        stmt.close();
        conn.close();
    }
}
