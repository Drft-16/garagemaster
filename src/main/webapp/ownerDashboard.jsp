<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.garagemaster.model.*" %>
<%@ page import="java.util.List" %>
<%
    Owner owner = (Owner) session.getAttribute("owner");
    if(owner == null) {
        response.sendRedirect("login");
        return;
    }
    List<Car> cars = (List<Car>) request.getAttribute("cars");
    List<Mechanic> mechanics = (List<Mechanic>) request.getAttribute("mechanics");
    List<Parts> parts = (List<Parts>) request.getAttribute("parts");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Owner Dashboard - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="navbar">
        <h2>GarageMaster - Owner Dashboard</h2>
        <div>
            <span>Welcome, <%= owner.getName() %></span>
            <a href="logout" class="btn btn-small">Logout</a>
        </div>
    </div>
    
    <div class="dashboard">
        <div class="section">
            <div class="section-header">
                <h3>Cars</h3>
                <a href="car?action=add" class="btn">Add Car</a>
            </div>
            <table>
                <tr>
                    <th>Make/Model</th>
                    <th>Year</th>
                    <th>License Plate</th>
                    <th>Work Description</th>
                    <th>Mechanic</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                <% if(cars != null && !cars.isEmpty()) {
                    for(Car car : cars) { %>
                <tr>
                    <td><%= car.getCarMake() %> <%= car.getCarModel() %></td>
                    <td><%= car.getYear() %></td>
                    <td><%= car.getLicensePlate() %></td>
                    <td><%= car.getWorkDescription() %></td>
                    <td><%= car.getMechanicName() != null ? car.getMechanicName() : "Not Assigned" %></td>
                    <td><span class="status status-<%= car.getStatus().toLowerCase().replace(" ", "-") %>"><%= car.getStatus() %></span></td>
                    <td>
                        <a href="car?action=edit&id=<%= car.getCarId() %>" class="btn-link">Edit</a>
                        <a href="car?action=delete&id=<%= car.getCarId() %>" class="btn-link" onclick="return confirm('Delete this car?')">Delete</a>
                    </td>
                </tr>
                <% } } else { %>
                <tr><td colspan="7" class="no-data">No cars added yet</td></tr>
                <% } %>
            </table>
        </div>
        
        <div class="section">
            <div class="section-header">
                <h3>Mechanics</h3>
                <a href="mechanic?action=add" class="btn">Add Mechanic</a>
            </div>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Specialization</th>
                    <th>Actions</th>
                </tr>
                <% if(mechanics != null && !mechanics.isEmpty()) {
                    for(Mechanic mechanic : mechanics) { %>
                <tr>
                    <td><%= mechanic.getName() %></td>
                    <td><%= mechanic.getEmail() %></td>
                    <td><%= mechanic.getPhone() %></td>
                    <td><%= mechanic.getSpecialization() %></td>
                    <td>
                        <a href="mechanic?action=edit&id=<%= mechanic.getMechanicId() %>" class="btn-link">Edit</a>
                        <a href="mechanic?action=delete&id=<%= mechanic.getMechanicId() %>" class="btn-link" onclick="return confirm('Delete this mechanic?')">Delete</a>
                    </td>
                </tr>
                <% } } else { %>
                <tr><td colspan="5" class="no-data">No mechanics added yet</td></tr>
                <% } %>
            </table>
        </div>
        
        <div class="section">
            <div class="section-header">
                <h3>Parts Inventory</h3>
                <a href="parts?action=add" class="btn">Add Part</a>
            </div>
            <table>
                <tr>
                    <th>Part Name</th>
                    <th>Part Number</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Compatible Makes</th>
                    <th>Actions</th>
                </tr>
                <% if(parts != null && !parts.isEmpty()) {
                    for(Parts part : parts) { %>
                <tr>
                    <td><%= part.getPartName() %></td>
                    <td><%= part.getPartNumber() %></td>
                    <td><%= part.getQuantity() %></td>
                    <td>₹<%= String.format("%.2f", part.getPrice()) %></td>
                    <td><%= part.getCompatibleMakes() %></td>
                    <td>
                        <a href="parts?action=edit&id=<%= part.getPartId() %>" class="btn-link">Edit</a>
                        <a href="parts?action=delete&id=<%= part.getPartId() %>" class="btn-link" onclick="return confirm('Delete this part?')">Delete</a>
                    </td>
                </tr>
                <% } } else { %>
                <tr><td colspan="6" class="no-data">No parts in inventory</td></tr>
                <% } %>
            </table>
        </div>
    </div>
</body>
</html>