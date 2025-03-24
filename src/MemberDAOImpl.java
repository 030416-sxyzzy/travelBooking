import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class MemberDAOImpl implements BaseDAO<Member> {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TravelBookingDB;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123456";

    @Override
    public void add(Member member) {
        String query = "INSERT INTO Member (Mname, Mphone, Mlevel, Mdate) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            // 从 Member 对象中获取数据并绑定到 PreparedStatement
            stmt.setString(1, member.getMname()); // 获取 Mname
            stmt.setString(2, member.getMphone()); // 获取 Mphone
            stmt.setString(3, member.getMlevel()); // 获取 Mlevel
            stmt.setDate(4, (Date) member.getMdate());    // 获取 Mate
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Member member) {
        String query = "UPDATE Member SET Mname = ?, Mphone = ?, Mlevel = ?, Mdate = ? WHERE Mid = ?";
        try (Connection conn = getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            // 从 Member 对象中获取数据并绑定到 PreparedStatement
            stmt.setString(1, member.getMname()); // 获取 Mname
            stmt.setString(2, member.getMphone()); // 获取 Mphone
            stmt.setString(3, member.getMlevel()); // 获取 Mlevel
            stmt.setDate(4, (Date) member.getMdate());    // 获取 Mdate
            stmt.setInt(5, member.getMid());       // 获取 Mid (用于更新指定的会员)
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating member: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Member WHERE Mid = ?";
        try (Connection conn = getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id); // 通过 Mid 删除
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting member: " + e.getMessage());
        }
    }


    @Override
    public List<Member> findById(int id) {
        List<Member> members = new ArrayList<>();
        String query = "SELECT * FROM Member WHERE Mid = ?";
        Member member = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id); // 设置 Mid 进行查询
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // 从 ResultSet 中获取数据并创建 Member 对象
                    members.add (new Member(
                            rs.getInt("Mid"),               // 获取 Mid
                            rs.getString("Mname"),          // 获取 Mname
                            rs.getString("Mphone"),         // 获取 Mphone
                            rs.getString("Mlevel"),         // 获取 Mlevel
                            rs.getDate("Mdate")             // 获取 Mdate
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}