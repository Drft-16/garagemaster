package com.garagemaster.servlet;

import com.garagemaster.dao.OwnerDAO;
import com.garagemaster.model.Owner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        
        Owner owner = new Owner();
        owner.setName(name);
        owner.setEmail(email);
        owner.setPassword(password);
        owner.setPhone(phone);
        
        OwnerDAO ownerDAO = new OwnerDAO();
        if (ownerDAO.register(owner)) {
            response.sendRedirect("login");
        } else {
            request.setAttribute("error", "Registration failed");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}