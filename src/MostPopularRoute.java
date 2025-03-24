import java.sql.*;

public class MostPopularRoute {

    // 数据库连接参数
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";

    public static void getMostPopularRoute() {
        // 连接对象
        Connection connection = null;
        // 声明Statement对象
        Statement statement = null;
        // 声明ResultSet对象，用来存储查询结果
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            String sql = "SELECT TOP 1 Rid, COUNT(*) AS booking_count " +
                    "FROM Booking " +
                    "GROUP BY Rid " +
                    "ORDER BY booking_count DESC " ;
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int rid = resultSet.getInt("Rid");  // 获取线路ID
                int bookingCount = resultSet.getInt("booking_count");  // 获取预订数量
                System.out.println("Most Popular Route ID: " + rid);
                System.out.println("Booking Count: " + bookingCount);
            } else {
                System.out.println("No data found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}