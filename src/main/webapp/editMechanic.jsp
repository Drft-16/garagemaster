<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.garagemaster.model.Mechanic" %>
<%
    Mechanic mechanic = (Mechanic) request.getAttribute("mechanic");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Mechanic - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>Edit Mechanic</h2>
            <form method="post" action="mechanic">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="mechanicId" value="<%= mechanic.getMechanicId() %>">
                
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" value="<%= mechanic.getName() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" value="<%= mechanic.getEmail() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" name="phone" value="<%= mechanic.getPhone() %>" required>
                </div>
                
                <div class="form-group">
                    <label>Specialization</label>
                    <input type="text" name="specialization" value="<%= mechanic.getSpecialization() %>" required>
                </div>
                
                <button type="submit" class="btn">Update Mechanic</button>
                <a href="ownerDashboard" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</body>
</html>	