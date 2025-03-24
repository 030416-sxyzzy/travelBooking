import java.sql.*;
import java.util.Scanner;

public class TicketBooking {

    // 数据库连接参数
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";

    public static void bookTicket(int tid, int quantity) throws SQLException {
        // 连接对象
        Connection connection = null;
        // 声明Statement对象
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            connection.setAutoCommit(false);

            String query = "SELECT Total_tickets FROM TourSpot WHERE Tid = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tid);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int currentTickets = resultSet.getInt("Total_tickets");

                // 5. 判断是否有足够的门票
                if (currentTickets >= quantity) {
                    // 6. 执行更新，减少TourSpot表中的Total_tickets
                    String updateQuery = "UPDATE TourSpot SET Total_tickets = Total_tickets - ? WHERE Tid = ?";
                    preparedStatement = connection.prepareStatement(updateQuery);
                    preparedStatement.setInt(1, quantity);
                    preparedStatement.setInt(2, tid);
                    int rowsAffected = preparedStatement.executeUpdate();

                    // 判断更新是否成功
                    if (rowsAffected > 0) {
                        // 7. 提交事务
                        connection.commit();
                        System.out.println("预定成功，门票数量已更新!");
                    } else {
                        // 如果没有更新记录，回滚事务
                        connection.rollback();
                        System.out.println("更新失败，预定未成功!");
                    }
                } else {
                    // 如果票数不足，回滚事务并提示错误信息
                    connection.rollback();
                    System.out.println("门票不足，预定失败!");
                }
            } else {
                System.out.println("线路ID不存在!");
            }
        } catch (SQLException e) {
            // 出现异常时回滚事务
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
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
