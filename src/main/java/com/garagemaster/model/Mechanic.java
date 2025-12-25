package com.garagemaster.model;

import java.sql.Timestamp;

public class Mechanic {
    private int mechanicId;
    private int ownerId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String specialization;
    private Timestamp createdAt;
    
    public Mechanic() {}
    
    public Mechanic(int mechanicId, int ownerId, String name, String email, String password, 
                    String phone, String specialization, Timestamp createdAt) {
        this.mechanicId = mechanicId;
        this.ownerId = ownerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.specialization = specialization;
        this.createdAt = createdAt;
    }
    
    public int getMechanicId() { return mechanicId; }
    public void setMechanicId(int mechanicId) { this.mechanicId = mechanicId; }
    
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}