import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";  // 修改为你的数据库密码

    // 根据会员 ID 查询预定
    @Override
    public List<Booking> findBookingsByMemberId(int memberId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM Booking WHERE Mid = ?";  // 假设 Bookings 表中有 Mid 字段

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, memberId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bookings.add(new Booking(
                            rs.getInt("Mid"),
                            rs.getInt("Tid"),
                            rs.getInt("Rid"),
                            rs.getInt("Hid"),
                            rs.getDate("Bdate")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // 根据酒店 ID 查询预定
    @Override
    public List<Booking> findBookingsByHotelId(int hotelId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM Booking WHERE Hid = ?";  // 假设 Bookings 表中有 Hid 字段

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, hotelId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bookings.add(new Booking(
                            rs.getInt("Mid"),
                            rs.getInt("Tid"),
                            rs.getInt("Rid"),
                            rs.getInt("Hid"),
                            rs.getDate("Bdate")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // 根据房间 ID 查询预定
    @Override
    public List<Booking> findBookingsByTourSpotId(int tourSpotId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM Booking WHERE Tid = ?";  // 假设 Bookings 表中有 Rid 字段

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tourSpotId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bookings.add(new Booking(
                            rs.getInt("Mid"),
                            rs.getInt("Tid"),
                            rs.getInt("Rid"),
                            rs.getInt("Hid"),
                            rs.getDate("Bdate")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    public List<Booking> findBookingsByRouteId(int routeId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM Booking WHERE Rid = ?";  // 假设 Bookings 表中有 Rid 字段

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, routeId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bookings.add(new Booking(
                            rs.getInt("Mid"),
                            rs.getInt("Tid"),
                            rs.getInt("Rid"),
                            rs.getInt("Hid"),
                            rs.getDate("Bdate")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}

