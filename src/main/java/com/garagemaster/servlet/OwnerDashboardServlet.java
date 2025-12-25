package com.garagemaster.servlet;

import com.garagemaster.dao.CarDAO;
import com.garagemaster.dao.MechanicDAO;
import com.garagemaster.dao.PartsDAO;
import com.garagemaster.model.Car;
import com.garagemaster.model.Mechanic;
import com.garagemaster.model.Owner;
import com.garagemaster.model.Parts;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ownerDashboard")
public class OwnerDashboardServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("owner") == null) {
            response.sendRedirect("login");
            return;
        }
        
        Owner owner = (Owner) session.getAttribute("owner");
        int ownerId = owner.getOwnerId();
        
        CarDAO carDAO = new CarDAO();
        MechanicDAO mechanicDAO = new MechanicDAO();
        PartsDAO partsDAO = new PartsDAO();	
        
        List<Car> cars = carDAO.getByOwnerId(ownerId);
        List<Mechanic> mechanics = mechanicDAO.getByOwnerId(ownerId);
        List<Parts> parts = partsDAO.getByOwnerId(ownerId);
        
        request.setAttribute("cars", cars);
        request.setAttribute("mechanics", mechanics);
        request.setAttribute("parts", parts);
        
        request.getRequestDispatcher("/ownerDashboard.jsp").forward(request, response);
    }
}