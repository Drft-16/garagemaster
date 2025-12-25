package com.garagemaster.servlet;

import com.garagemaster.dao.MechanicDAO;
import com.garagemaster.model.Mechanic;
import com.garagemaster.model.Owner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/mechanic")
public class MechanicServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("owner") == null) {
            response.sendRedirect("login");
            return;
        }
        
        Owner owner = (Owner) session.getAttribute("owner");
        String action = request.getParameter("action");
        MechanicDAO mechanicDAO = new MechanicDAO();
        
        if ("add".equals(action)) {
            request.getRequestDispatcher("/addMechanic.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int mechanicId = Integer.parseInt(request.getParameter("id"));
            Mechanic mechanic = mechanicDAO.getById(mechanicId, owner.getOwnerId());
            request.setAttribute("mechanic", mechanic);
            request.getRequestDispatcher("/editMechanic.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int mechanicId = Integer.parseInt(request.getParameter("id"));
            mechanicDAO.delete(mechanicId, owner.getOwnerId());
            response.sendRedirect("ownerDashboard");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("owner") == null) {
            response.sendRedirect("login");
            return;
        }
        
        Owner owner = (Owner) session.getAttribute("owner");
        String action = request.getParameter("action");
        MechanicDAO mechanicDAO = new MechanicDAO();
        
        Mechanic mechanic = new Mechanic();
        mechanic.setOwnerId(owner.getOwnerId());
        mechanic.setName(request.getParameter("name"));
        mechanic.setEmail(request.getParameter("email"));
        mechanic.setPhone(request.getParameter("phone"));
        mechanic.setSpecialization(request.getParameter("specialization"));
        
        if ("add".equals(action)) {
            mechanic.setPassword(request.getParameter("password"));
            mechanicDAO.add(mechanic);
        } else if ("edit".equals(action)) {
            mechanic.setMechanicId(Integer.parseInt(request.getParameter("mechanicId")));
            mechanicDAO.update(mechanic);
        }
        
        response.sendRedirect("ownerDashboard");
    }
}