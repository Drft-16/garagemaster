<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.garagemaster.model.*" %>
<%@ page import="java.util.List" %>
<%
    List<Mechanic> mechanics = (List<Mechanic>) request.getAttribute("mechanics");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Car - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>Add New Car</h2>
            <form method="post" action="car">
                <input type="hidden" name="action" value="add">
                
                <div class="form-group">
                    <label>Car Make</label>
                    <input type="text" name="carMake" required>
                </div>
                
                <div class="form-group">
                    <label>Car Model</label>
                    <input type="text" name="carModel" required>
                </div>
                
                <div class="form-group">
                    <label>Year</label>
                    <input type="number" name="year" required>
                </div>
                
                <div class="form-group">
                    <label>License Plate</label>
                    <input type="text" name="licensePlate" required>
                </div>
                
                <div class="form-group">
                    <label>Work Description</label>
                    <textarea name="workDescription" rows="4" required></textarea>
                </div>
                
                <div class="form-group">
                    <label>Assign Mechanic</label>
                    <select name="mechanicId">
                        <option value="0">Not Assigned</option>
                        <% if(mechanics != null) {
                            for(Mechanic m : mechanics) { %>
                        <option value="<%= m.getMechanicId() %>"><%= m.getName() %> - <%= m.getSpecialization() %></option>
                        <% } } %>
                    </select>
                </div>
                
                <div class="form-group">
                    <label>Status</label>
                    <select name="status">
                        <option value="Pending">Pending</option>
                        <option value="In Progress">In Progress</option>
                        <option value="Completed">Completed</option>
                        <option value="On Hold">On Hold</option>
                        <option value="Cancelled">Cancelled</option>
                    </select>
                </div>
                
                <button type="submit" class="btn">Add Car</button>
                <a href="ownerDashboard" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</body>
</html>