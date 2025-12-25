<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.garagemaster.model.*" %>
<%@ page import="java.util.List" %>
<%
    Car car = (Car) request.getAttribute("car");
    List<Mechanic> mechanics = (List<Mechanic>) request.getAttribute("mechanics");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Car - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>Edit Car</h2>
            <form method="post" action="car">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="carId" value="<%= car.getCarId() %>">
                
                <div class="form-group">
                    <label>Car Make</label>
                    <input type="text" name="carMake" value="<%= car.getCarMake() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Car Model</label>
                    <input type="text" name="carModel" value="<%= car.getCarModel() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Year</label>
                    <input type="number" name="year" value="<%= car.getYear() %>" required>
                </div>
                
                <div class="form-group">
                    <label>License Plate</label>
                    <input type="text" name="licensePlate" value="<%= car.getLicensePlate() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Work Description</label>
                    <textarea name="workDescription" rows="4" required><%= car.getWorkDescription() %></textarea>
                </div>
                
                <div class="form-group">
                    <label>Assign Mechanic</label>
                    <select name="mechanicId">
                        <option value="0">Not Assigned</option>
                        <% if(mechanics != null) {
                            for(Mechanic m : mechanics) { %>
                        <option value="<%= m.getMechanicId() %>" <%= car.getMechanicId() != null && car.getMechanicId() == m.getMechanicId() ? "selected" : "" %>><%= m.getName() %> - <%= m.getSpecialization() %></option>
                        <% } } %>
                    </select>
                </div>
                
                <div class="form-group">
                    <label>Status</label>
                    <select name="status">
                        <option value="Pending" <%= "Pending".equals(car.getStatus()) ? "selected" : "" %>>Pending</option>
                        <option value="In Progress" <%= "In Progress".equals(car.getStatus()) ? "selected" : "" %>>In Progress</option>
                        <option value="Completed" <%= "Completed".equals(car.getStatus()) ? "selected" : "" %>>Completed</option>
                        <option value="On Hold" <%= "On Hold".equals(car.getStatus()) ? "selected" : "" %>>On Hold</option>
                        <option value="Cancelled" <%= "Cancelled".equals(car.getStatus()) ? "selected" : "" %>>Cancelled</option>
                    </select>
                </div>
                
                <button type="submit" class="btn">Update Car</button>
                <a href="ownerDashboard" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</body>
</html>