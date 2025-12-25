package com.garagemaster.servlet;

import com.garagemaster.dao.PartsDAO;
import com.garagemaster.model.Owner;
import com.garagemaster.model.Parts;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/parts")
public class PartsServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("owner") == null) {
            response.sendRedirect("login");
            return;
        }
        
        Owner owner = (Owner) session.getAttribute("owner");
        String action = request.getParameter("action");
        PartsDAO partsDAO = new PartsDAO();
        
        if ("add".equals(action)) {
            request.getRequestDispatcher("addParts.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int partId = Integer.parseInt(request.getParameter("id"));
            Parts part = partsDAO.getById(partId, owner.getOwnerId());
            request.setAttribute("part", part);
            request.getRequestDispatcher("editParts.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int partId = Integer.parseInt(request.getParameter("id"));
            partsDAO.delete(partId, owner.getOwnerId());
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
        PartsDAO partsDAO = new PartsDAO();
        
        Parts part = new Parts();
        part.setOwnerId(owner.getOwnerId());
        part.setPartName(request.getParameter("partName"));
        part.setPartNumber(request.getParameter("partNumber"));
        part.setDescription(request.getParameter("description"));
        part.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        part.setPrice(Double.parseDouble(request.getParameter("price")));
        part.setCompatibleMakes(request.getParameter("compatibleMakes"));
        part.setCompatibleModels(request.getParameter("compatibleModels"));
        
        if ("add".equals(action)) {
            partsDAO.add(part);
        } else if ("edit".equals(action)) {
            part.setPartId(Integer.parseInt(request.getParameter("partId")));
            partsDAO.update(part);
        }
        
        response.sendRedirect("ownerDashboard");
    }
}