<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.garagemaster.model.*" %>
<%@ page import="java.util.List" %>
<%
    Mechanic mechanic = (Mechanic) session.getAttribute("mechanic");
    if(mechanic == null) {
        response.sendRedirect("login");
        return;
    }
    List<Car> cars = (List<Car>) request.getAttribute("cars");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Mechanic Dashboard - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="navbar">
        <h2>GarageMaster - Mechanic Dashboard</h2>
        <div>
            <span>Welcome, <%= mechanic.getName() %></span>
            <a href="logout" class="btn btn-small">Logout</a>
        </div>
    </div>
    
    <div class="dashboard">
        <div class="section">
            <h3>Assigned Cars</h3>
            <table>
                <tr>
                    <th>Make/Model</th>
                    <th>Year</th>
                    <th>License Plate</th>
                    <th>Work Description</th>
                    <th>Status</th>
                    <th>Update Status</th>
                </tr>
                <% if(cars != null && !cars.isEmpty()) {
                    for(Car car : cars) { %>
                <tr>
                    <td><%= car.getCarMake() %> <%= car.getCarModel() %></td>
                    <td><%= car.getYear() %></td>
                    <td><%= car.getLicensePlate() %></td>
                    <td><%= car.getWorkDescription() %></td>
                    <td><span class="status status-<%= car.getStatus().toLowerCase().replace(" ", "-") %>"><%= car.getStatus() %></span></td>
                    <td>
                        <form method="post" action="updateStatus" style="display:inline;">
                            <input type="hidden" name="carId" value="<%= car.getCarId() %>">
                            <select name="status">
                                <option value="Pending" <%= "Pending".equals(car.getStatus()) ? "selected" : "" %>>Pending</option>
                                <option value="In Progress" <%= "In Progress".equals(car.getStatus()) ? "selected" : "" %>>In Progress</option>
                                <option value="Completed" <%= "Completed".equals(car.getStatus()) ? "selected" : "" %>>Completed</option>
                                <option value="On Hold" <%= "On Hold".equals(car.getStatus()) ? "selected" : "" %>>On Hold</option>
                                <option value="Cancelled" <%= "Cancelled".equals(car.getStatus()) ? "selected" : "" %>>Cancelled</option>
                            </select>
                            <button type="submit" class="btn btn-small">Update</button>
                        </form>
                    </td>
                </tr>
                <% } } else { %>
                <tr><td colspan="6" class="no-data">No cars assigned yet</td></tr>
                <% } %>
            </table>
        </div>
    </div>
</body>
</html>