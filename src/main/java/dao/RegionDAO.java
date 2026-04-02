package dao;

import domain.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO {

    public List<Region> findAll() {

        List<Region> list = new ArrayList<>();
        String sql = "SELECT * FROM regions";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Region r = new Region();
                r.setId(rs.getLong("id"));
                r.setName(rs.getString("name"));
                r.setArea(rs.getString("area"));
                r.setAdminCenter(rs.getString("admincenter"));
                r.setHead(rs.getString("head"));
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(Region r) {

        String sql = "INSERT INTO regions(name, area, admincenter, head) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getName());
            ps.setString(2, r.getArea());
            ps.setString(3, r.getAdminCenter());
            ps.setString(4, r.getHead());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {

        String sql = "DELETE FROM regions WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Region r) {

        String sql = "UPDATE regions SET name=?, area=?, admincenter=?, head=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getName());
            ps.setString(2, r.getArea());
            ps.setString(3, r.getAdminCenter());
            ps.setString(4, r.getHead());
            ps.setLong(5, r.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}