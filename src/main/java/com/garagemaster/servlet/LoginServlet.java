package com.garagemaster.servlet;

import com.garagemaster.dao.MechanicDAO;
import com.garagemaster.dao.OwnerDAO;
import com.garagemaster.model.Mechanic;
import com.garagemaster.model.Owner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        
        HttpSession session = request.getSession();
        
        if ("owner".equals(userType)) {
            OwnerDAO ownerDAO = new OwnerDAO();
            Owner owner = ownerDAO.login(email, password);
            if (owner != null) {
                session.setAttribute("owner", owner);
                session.setAttribute("userType", "owner");
                response.sendRedirect("ownerDashboard");
            } else {
                request.setAttribute("error", "Invalid credentials");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if ("mechanic".equals(userType)) {
            MechanicDAO mechanicDAO = new MechanicDAO();
            Mechanic mechanic = mechanicDAO.login(email, password);
            if (mechanic != null) {
                session.setAttribute("mechanic", mechanic);
                session.setAttribute("userType", "mechanic");
                response.sendRedirect("mechanicDashboard");
            } else {
                request.setAttribute("error", "Invalid credentials");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}