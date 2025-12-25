package com.garagemaster.servlet;

import com.garagemaster.dao.CarDAO;
import com.garagemaster.model.Car;
import com.garagemaster.model.Mechanic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ mechanicDashboard")
public class MechanicDashboardServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("mechanic") == null) {
            response.sendRedirect("login");
            return;
        }
        
        Mechanic mechanic = (Mechanic) session.getAttribute("mechanic");
        CarDAO carDAO = new CarDAO();
        List<Car> assignedCars = carDAO.getByMechanicId(mechanic.getMechanicId());
        
        request.setAttribute("cars", assignedCars);
        request.getRequestDispatcher("/mechanicDashboard.jsp").forward(request, response);
    }
}