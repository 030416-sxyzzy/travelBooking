import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoutemanageDAOImpl {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";

    public List<Routemanage> findAllRoutemanageWithDetails() {
        List<Routemanage> routemanages = new ArrayList<>();
        String query = "SELECT rm.*, rt.*, ts.*, r.*, h.* " +
                "FROM Routemanage rm " +
                "JOIN Rtraffic rt ON rm.Rtrafficid = rt.Rtrafficid " +
                "JOIN TourSpot ts ON rm.Tid = ts.Tid " +
                "JOIN Route r ON rm.Rid = r.Rid " +
                "JOIN Hotel h ON rm.Hid = h.Hid";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Routemanage routemanage = new Routemanage();
                routemanage.setRtrafficid(rs.getInt("Rtrafficid"));
                routemanage.setTid(rs.getInt("Tid"));
                routemanage.setRid(rs.getInt("Rid"));
                routemanage.setHid(rs.getInt("Hid"));
                // 创建并设置 Rtraffic 对象
                Rtraffic rtraffic = new Rtraffic();
                rtraffic.setRtrafficid(rs.getInt("Rtrafficid"));
                rtraffic.setRtrafficway(rs.getString("Rtrafficway"));
                routemanage.setRtraffic(rtraffic);
                // 创建并设置 TourSpot 对象
                TourSpot tourSpot = new TourSpot();
                tourSpot.setTid(rs.getInt("Tid"));
                tourSpot.setTname(rs.getString("Tname"));
                tourSpot.setTprice(rs.getShort("Tprice"));
                tourSpot.setTlocation(rs.getString("Tlocation"));
                tourSpot.setTdate(rs.getDate("Tdate"));
                routemanage.setTourSpot(tourSpot);

                // 创建并设置 Route 对象
                Route route = new Route();
                route.setRid(rs.getInt("Rid"));
                route.setRname(rs.getString("Rname"));
                routemanage.setRoute(route);

                // 创建并设置 Hotel 对象
                Hotel hotel = new Hotel();
                hotel.setHid(rs.getInt("Hid"));
                hotel.setHname(rs.getString("Hname"));
                hotel.setHprice(rs.getShort("Hprice"));
                hotel.setHstyle(rs.getString("Hstyle"));
                hotel.setHstarrating(rs.getShort("Hstarrating"));
                hotel.setHlocation(rs.getString("Hlocation"));
                routemanage.setHotel(hotel);

                routemanages.add(routemanage);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routemanages;
    }
}
