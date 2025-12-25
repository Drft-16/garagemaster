<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Part - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>Add New Part</h2>
            <form method="post" action="parts">
                <input type="hidden" name="action" value="add">
                
                <div class="form-group">
                    <label>Part Name</label>
                    <input type="text" name="partName" required>
                </div>
                
                <div class="form-group">
                    <label>Part Number</label>
                    <input type="text" name="partNumber" required>
                </div>
                
                <div class="form-group">
                    <label>Description</label>
                    <textarea name="description" rows="3"></textarea>
                </div>
                
                <div class="form-group">
                    <label>Quantity</label>
                    <input type="number" name="quantity" required>
                </div>
                
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" step="0.01" name="price" required>
                </div>
                
                <div class="form-group">
                    <label>Compatible Makes</label>
                    <input type="text" name="compatibleMakes" placeholder="e.g. Toyota, Honda">
                </div>
                
                <div class="form-group">
                    <label>Compatible Models</label>
                    <input type="text" name="compatibleModels" placeholder="e.g. Camry, Accord">
                </div>
                
                <button type="submit" class="btn">Add Part</button>
                <a href="ownerDashboard" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</body>
</html>