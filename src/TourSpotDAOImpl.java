import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourSpotDAOImpl implements BaseDAO<TourSpot> {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";

    @Override
    public void add(TourSpot tourSpot) {
        String query = "INSERT INTO TourSpot (Tname, Tprice, Tlocation, Tdate) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tourSpot.getTname());
            stmt.setShort(2, tourSpot.getTprice());
            stmt.setString(3, tourSpot.getTlocation());
            stmt.setDate(4, tourSpot.getTdate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TourSpot tourSpot) {
        String query = "UPDATE TourSpot SET Tname = ?, Tprice = ?, Tlocation = ?, Tdate = ? WHERE Tid = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tourSpot.getTname());
            stmt.setShort(2, tourSpot.getTprice());
            stmt.setString(3, tourSpot.getTlocation());
            stmt.setDate(4, tourSpot.getTdate());
            stmt.setInt(5, tourSpot.getTid());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM TourSpot WHERE Tid = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TourSpot> findById(int id) {
        List<TourSpot> tourSpots = new ArrayList<>();
        String query = "SELECT * FROM TourSpot WHERE Tid = ?";
        TourSpot tourSpot = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tourSpot = new TourSpot(
                 rs.getInt("Tid"),
                 rs.getString("Tname"),
                 rs.getShort("Tprice"),
                 rs.getString("Tlocation"),
                 rs.getDate("Tdate")); // 注意这里是java.sql.Date

                // 使用带参数的构造器
                tourSpots.add(tourSpot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tourSpots;
    }
    }
