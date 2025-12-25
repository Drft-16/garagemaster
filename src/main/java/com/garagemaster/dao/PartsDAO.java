package com.garagemaster.dao;

import com.garagemaster.model.Parts;
import com.garagemaster.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartsDAO {
    
    public boolean add(Parts part) {
        String sql = "INSERT INTO parts (owner_id, part_name, part_number, description, quantity, price, compatible_makes, compatible_models) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, part.getOwnerId());
            ps.setString(2, part.getPartName());
            ps.setString(3, part.getPartNumber());
            ps.setString(4, part.getDescription());
            ps.setInt(5, part.getQuantity());
            ps.setDouble(6, part.getPrice());
            ps.setString(7, part.getCompatibleMakes());
            ps.setString(8, part.getCompatibleModels());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Parts> getByOwnerId(int ownerId) {
        List<Parts> parts = new ArrayList<>();
        String sql = "SELECT * FROM parts WHERE owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ownerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                parts.add(new Parts(
                    rs.getInt("part_id"),
                    rs.getInt("owner_id"),
                    rs.getString("part_name"),
                    rs.getString("part_number"),
                    rs.getString("description"),
                    rs.getInt("quantity"),
                    rs.getDouble("price"),
                    rs.getString("compatible_makes"),
                    rs.getString("compatible_models"),
                    rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parts;
    }
    
    public Parts getById(int partId, int ownerId) {
        String sql = "SELECT * FROM parts WHERE part_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, partId);
            ps.setInt(2, ownerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Parts(
                    rs.getInt("part_id"),
                    rs.getInt("owner_id"),
                    rs.getString("part_name"),
                    rs.getString("part_number"),
                    rs.getString("description"),
                    rs.getInt("quantity"),
                    rs.getDouble("price"),
                    rs.getString("compatible_makes"),
                    rs.getString("compatible_models"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Parts part) {
        String sql = "UPDATE parts SET part_name = ?, part_number = ?, description = ?, quantity = ?, price = ?, compatible_makes = ?, compatible_models = ? WHERE part_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, part.getPartName());
            ps.setString(2, part.getPartNumber());
            ps.setString(3, part.getDescription());
            ps.setInt(4, part.getQuantity());
            ps.setDouble(5, part.getPrice());
            ps.setString(6, part.getCompatibleMakes());
            ps.setString(7, part.getCompatibleModels());
            ps.setInt(8, part.getPartId());
            ps.setInt(9, part.getOwnerId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int partId, int ownerId) {
        String sql = "DELETE FROM parts WHERE part_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, partId);
            ps.setInt(2, ownerId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}