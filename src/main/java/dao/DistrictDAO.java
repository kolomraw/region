package dao;

import domain.District;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistrictDAO {

    public List<District> findAll() {

        List<District> list = new ArrayList<>();
        String sql = "SELECT * FROM districts";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                District d = new District();
                d.setId(rs.getLong("id"));
                d.setName(rs.getString("name"));
                d.setArea(rs.getString("area"));
                d.setAdminCenter(rs.getString("admincenter"));
                d.setHead(rs.getString("head"));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(District d) {

        String sql = "INSERT INTO districts(name, area, admincenter, head) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setString(2, d.getArea());
            ps.setString(3, d.getAdminCenter());
            ps.setString(4, d.getHead());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {

        String sql = "DELETE FROM districts WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(District d) {

        String sql = "UPDATE districts SET name=?, area=?, admincenter=?, head=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setString(2, d.getArea());
            ps.setString(3, d.getAdminCenter());
            ps.setString(4, d.getHead());
            ps.setLong(5, d.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}