<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.garagemaster.model.Parts" %>
<%
    Parts part = (Parts) request.getAttribute("part");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Part - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>Edit Part</h2>
            <form method="post" action="parts">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="partId" value="<%= part.getPartId() %>">
                
                <div class="form-group">
                    <label>Part Name</label>
                    <input type="text" name="partName" value="<%= part.getPartName() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Part Number</label>
                    <input type="text" name="partNumber" value="<%= part.getPartNumber() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Description</label>
                    <textarea name="description" rows="3"><%= part.getDescription() != null ? part.getDescription() : "" %></textarea>
                </div>
                
                <div class="form-group">
                    <label>Quantity</label>
                    <input type="number" name="quantity" value="<%= part.getQuantity() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" step="0.01" name="price" value="<%= part.getPrice() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Compatible Makes</label>
                    <input type="text" name="compatibleMakes" value="<%= part.getCompatibleMakes() != null ? part.getCompatibleMakes() : "" %>">
                </div>
                
                <div class="form-group">
                    <label>Compatible Models</label>
                    <input type="text" name="compatibleModels" value="<%= part.getCompatibleModels() != null ? part.getCompatibleModels() : "" %>">
                </div>
                
                <button type="submit" class="btn">Update Part</button>
                <a href="ownerDashboard" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</body>
</html>