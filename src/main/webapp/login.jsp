<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - GarageMaster</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <div class="form-box">
            <h1>GarageMaster</h1>
            <h2>Login</h2>
            
            <% if(request.getAttribute("success") != null) { %>
                <div class="success"><%= request.getAttribute("success") %></div>
            <% } %>
            
            <% if(request.getAttribute("error") != null) { %>
                <div class="error"><%= request.getAttribute("error") %></div>
            <% } %>
            
            <form method="post" action="login">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" required>
                </div>
                
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" required>
                </div>
                
                <div class="form-group">
                    <label>Login as</label>
                    <select name="userType" required>
                        <option value="owner">Owner</option>
                        <option value="mechanic">Mechanic</option>
                    </select>
                </div>
                
                <button type="submit" class="btn">Login</button>
            </form>
            
            <p class="link">Don't have an account? <a href="register">Register as Owner</a></p>
        </div>
    </div>
</body>
</html>