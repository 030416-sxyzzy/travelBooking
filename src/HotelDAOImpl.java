import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements BaseDAO<Hotel> {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";

    @Override
    public void add(Hotel hotel) {
        String query = "INSERT INTO Hotel (Hname, Hprice, Hstyle, Hstarrating, Hlocation) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, hotel.getHname());
            stmt.setShort(2, hotel.getHprice());
            stmt.setString(3, hotel.getHstyle());
            stmt.setShort(4, hotel.getHstarrating());
            stmt.setString(5, hotel.getHlocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hotel hotel) {
        String query = "UPDATE Hotel SET Hname = ?, Hprice = ?, Hstyle = ?, Hstarrating = ?, Hlocation = ? WHERE Hid = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, hotel.getHname());
            stmt.setShort(2, hotel.getHprice());
            stmt.setString(3, hotel.getHstyle());
            stmt.setShort(4, hotel.getHstarrating());
            stmt.setString(5, hotel.getHlocation());
            stmt.setInt(6, hotel.getHid());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Hotel WHERE Hid = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> findById(int id) {
        List<Hotel> hotels= new ArrayList<>();
        String query = "SELECT * FROM Hotel WHERE Hid = ?";
        Hotel hotel = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // 从 ResultSet 中获取数据并创建 Hotel 对象
                hotel = new Hotel(
                        rs.getInt("Hid"),      // 假设 `Hid` 是主键
                        rs.getString("Hname"),
                        rs.getShort("Hprice"),
                        rs.getString("Hstyle"),
                        rs.getShort("Hstarrating"),
                        rs.getString("Hlocation")
                );
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

}
