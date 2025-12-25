package com.garagemaster.dao;

import com.garagemaster.model.Mechanic;
import com.garagemaster.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MechanicDAO {
    
    public Mechanic login(String email, String password) {
        String sql = "SELECT * FROM mechanics WHERE email = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Mechanic(
                    rs.getInt("mechanic_id"),
                    rs.getInt("owner_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("specialization"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean add(Mechanic mechanic) {
        String sql = "INSERT INTO mechanics (owner_id, name, email, password, phone, specialization) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, mechanic.getOwnerId());
            ps.setString(2, mechanic.getName());
            ps.setString(3, mechanic.getEmail());
            ps.setString(4, mechanic.getPassword());
            ps.setString(5, mechanic.getPhone());
            ps.setString(6, mechanic.getSpecialization());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Mechanic> getByOwnerId(int ownerId) {
        List<Mechanic> mechanics = new ArrayList<>();
        String sql = "SELECT * FROM mechanics WHERE owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ownerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mechanics.add(new Mechanic(
                    rs.getInt("mechanic_id"),
                    rs.getInt("owner_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("specialization"),
                    rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mechanics;
    }
    
    public Mechanic getById(int mechanicId, int ownerId) {
        String sql = "SELECT * FROM mechanics WHERE mechanic_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, mechanicId);
            ps.setInt(2, ownerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Mechanic(
                    rs.getInt("mechanic_id"),
                    rs.getInt("owner_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("specialization"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Mechanic mechanic) {
        String sql = "UPDATE mechanics SET name = ?, email = ?, phone = ?, specialization = ? WHERE mechanic_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mechanic.getName());
            ps.setString(2, mechanic.getEmail());
            ps.setString(3, mechanic.getPhone());
            ps.setString(4, mechanic.getSpecialization());
            ps.setInt(5, mechanic.getMechanicId());
            ps.setInt(6, mechanic.getOwnerId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int mechanicId, int ownerId) {
        String sql = "DELETE FROM mechanics WHERE mechanic_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, mechanicId);
            ps.setInt(2, ownerId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}