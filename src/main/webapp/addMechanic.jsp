<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Mechanic - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h2>Add New Mechanic</h2>
            <form method="post" action="mechanic">
                <input type="hidden" name="action" value="add">
                
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" required>
                </div>
                
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" required>
                </div>
                
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" required>
                </div>
                
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" name="phone" required>
                </div>
                
                <div class="form-group">
                    <label>Specialization</label>
                    <input type="text" name="specialization" required>
                </div>
                
                <button type="submit" class="btn">Add Mechanic</button>
                <a href="ownerDashboard" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</body>
</html>