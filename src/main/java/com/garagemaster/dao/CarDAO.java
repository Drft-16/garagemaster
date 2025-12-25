package com.garagemaster.dao;

import com.garagemaster.model.Car;
import com.garagemaster.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    
    public boolean add(Car car) {
        String sql = "INSERT INTO cars (owner_id, mechanic_id, car_make, car_model, year, license_plate, work_description, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, car.getOwnerId());
            if (car.getMechanicId() != null) {
                ps.setInt(2, car.getMechanicId());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setString(3, car.getCarMake());
            ps.setString(4, car.getCarModel());
            ps.setInt(5, car.getYear());
            ps.setString(6, car.getLicensePlate());
            ps.setString(7, car.getWorkDescription());
            ps.setString(8, car.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Car> getByOwnerId(int ownerId) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT c.*, m.name as mechanic_name FROM cars c LEFT JOIN mechanics m ON c.mechanic_id = m.mechanic_id WHERE c.owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ownerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car(
                    rs.getInt("car_id"),
                    rs.getInt("owner_id"),
                    (Integer) rs.getObject("mechanic_id"),
                    rs.getString("car_make"),
                    rs.getString("car_model"),
                    rs.getInt("year"),
                    rs.getString("license_plate"),
                    rs.getString("work_description"),
                    rs.getString("status"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                car.setMechanicName(rs.getString("mechanic_name"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    
    public List<Car> getByMechanicId(int mechanicId) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE mechanic_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, mechanicId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(new Car(
                    rs.getInt("car_id"),
                    rs.getInt("owner_id"),
                    (Integer) rs.getObject("mechanic_id"),
                    rs.getString("car_make"),
                    rs.getString("car_model"),
                    rs.getInt("year"),
                    rs.getString("license_plate"),
                    rs.getString("work_description"),
                    rs.getString("status"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    
    public Car getById(int carId, int ownerId) {
        String sql = "SELECT c.*, m.name as mechanic_name FROM cars c LEFT JOIN mechanics m ON c.mechanic_id = m.mechanic_id WHERE c.car_id = ? AND c.owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, carId);
            ps.setInt(2, ownerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Car car = new Car(
                    rs.getInt("car_id"),
                    rs.getInt("owner_id"),
                    (Integer) rs.getObject("mechanic_id"),
                    rs.getString("car_make"),
                    rs.getString("car_model"),
                    rs.getInt("year"),
                    rs.getString("license_plate"),
                    rs.getString("work_description"),
                    rs.getString("status"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                car.setMechanicName(rs.getString("mechanic_name"));
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(Car car) {
        String sql = "UPDATE cars SET mechanic_id = ?, car_make = ?, car_model = ?, year = ?, license_plate = ?, work_description = ?, status = ? WHERE car_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (car.getMechanicId() != null) {
                ps.setInt(1, car.getMechanicId());
            } else {
                ps.setNull(1, Types.INTEGER);
            }
            ps.setString(2, car.getCarMake());
            ps.setString(3, car.getCarModel());
            ps.setInt(4, car.getYear());
            ps.setString(5, car.getLicensePlate());
            ps.setString(6, car.getWorkDescription());
            ps.setString(7, car.getStatus());
            ps.setInt(8, car.getCarId());
            ps.setInt(9, car.getOwnerId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateStatus(int carId, String status) {
        String sql = "UPDATE cars SET status = ? WHERE car_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, carId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int carId, int ownerId) {
        String sql = "DELETE FROM cars WHERE car_id = ? AND owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, carId);
            ps.setInt(2, ownerId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}