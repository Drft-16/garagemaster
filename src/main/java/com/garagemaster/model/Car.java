package com.garagemaster.model;

import java.sql.Timestamp;

public class Car {
    private int carId;
    private int ownerId;
    private Integer mechanicId;
    private String carMake;
    private String carModel;
    private int year;
    private String licensePlate;
    private String workDescription;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String mechanicName;
    
    public Car() {}
    
    public Car(int carId, int ownerId, Integer mechanicId, String carMake, String carModel, 
               int year, String licensePlate, String workDescription, String status, 
               Timestamp createdAt, Timestamp updatedAt) {
        this.carId = carId;
        this.ownerId = ownerId;
        this.mechanicId = mechanicId;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
        this.licensePlate = licensePlate;
        this.workDescription = workDescription;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }
    
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    
    public Integer getMechanicId() { return mechanicId; }
    public void setMechanicId(Integer mechanicId) { this.mechanicId = mechanicId; }
    
    public String getCarMake() { return carMake; }
    public void setCarMake(String carMake) { this.carMake = carMake; }
    
    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }
    
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    
    public String getWorkDescription() { return workDescription; }
    public void setWorkDescription(String workDescription) { this.workDescription = workDescription; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    
    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
    
    public String getMechanicName() { return mechanicName; }
    public void setMechanicName(String mechanicName) { this.mechanicName = mechanicName; }
}