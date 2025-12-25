package com.garagemaster.model;

import java.sql.Timestamp;

public class PartsUsage {
    private int usageId;
    private int carId;
    private int partId;
    private int quantityUsed;
    private Timestamp usedAt;
    private String partName;
    private String carDetails;
    
    public PartsUsage() {}
    
    public PartsUsage(int usageId, int carId, int partId, int quantityUsed, Timestamp usedAt) {
        this.usageId = usageId;
        this.carId = carId;
        this.partId = partId;
        this.quantityUsed = quantityUsed;
        this.usedAt = usedAt;
    }
    
    public int getUsageId() { return usageId; }
    public void setUsageId(int usageId) { this.usageId = usageId; }
    
    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }
    
    public int getPartId() { return partId; }
    public void setPartId(int partId) { this.partId = partId; }
    
    public int getQuantityUsed() { return quantityUsed; }
    public void setQuantityUsed(int quantityUsed) { this.quantityUsed = quantityUsed; }
    
    public Timestamp getUsedAt() { return usedAt; }
    public void setUsedAt(Timestamp usedAt) { this.usedAt = usedAt; }
    
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    
    public String getCarDetails() { return carDetails; }
    public void setCarDetails(String carDetails) { this.carDetails = carDetails; }
}