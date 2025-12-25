package com.garagemaster.model;

import java.sql.Timestamp;

public class Parts {
    private int partId;
    private int ownerId;
    private String partName;
    private String partNumber;
    private String description;
    private int quantity;
    private double price;
    private String compatibleMakes;
    private String compatibleModels;
    private Timestamp createdAt;
    
    public Parts() {}
    
    public Parts(int partId, int ownerId, String partName, String partNumber, String description,
                 int quantity, double price, String compatibleMakes, String compatibleModels, 
                 Timestamp createdAt) {
        this.partId = partId;
        this.ownerId = ownerId;
        this.partName = partName;
        this.partNumber = partNumber;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.compatibleMakes = compatibleMakes;
        this.compatibleModels = compatibleModels;
        this.createdAt = createdAt;
    }
    
    public int getPartId() { return partId; }
    public void setPartId(int partId) { this.partId = partId; }
    
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    
    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public String getCompatibleMakes() { return compatibleMakes; }
    public void setCompatibleMakes(String compatibleMakes) { this.compatibleMakes = compatibleMakes; }
    
    public String getCompatibleModels() { return compatibleModels; }
    public void setCompatibleModels(String compatibleModels) { this.compatibleModels = compatibleModels; }
    
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}