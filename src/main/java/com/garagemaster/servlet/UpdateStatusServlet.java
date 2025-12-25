package com.garagemaster.servlet;

import com.garagemaster.dao.CarDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("mechanic") == null) {
            response.sendRedirect("login");
            return;
        }
        
        int carId = Integer.parseInt(request.getParameter("carId"));
        String status = request.getParameter("status");
        
        CarDAO carDAO = new CarDAO();
        carDAO.updateStatus(carId, status);
        
        response.sendRedirect("mechanicDashboard");
    }
}