package com.garagemaster.servlet;

import com.garagemaster.dao.CarDAO;
import com.garagemaster.dao.MechanicDAO;
import com.garagemaster.model.Car;
import com.garagemaster.model.Mechanic;
import com.garagemaster.model.Owner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/car")
public class CarServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("owner") == null) {
            response.sendRedirect("login");
            return;
        }
        
        Owner owner = (Owner) session.getAttribute("owner");
        String action = request.getParameter("action");
        CarDAO carDAO = new CarDAO();
        MechanicDAO mechanicDAO = new MechanicDAO();
        
        if ("add".equals(action)) {
            List<Mechanic> mechanics = mechanicDAO.getByOwnerId(owner.getOwnerId());
            request.setAttribute("mechanics", mechanics);
            request.getRequestDispatcher("/addCar.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int carId = Integer.parseInt(request.getParameter("id"));
            Car car = carDAO.getById(carId, owner.getOwnerId());
            List<Mechanic> mechanics = mechanicDAO.getByOwnerId(owner.getOwnerId());
            request.setAttribute("car", car);
            request.setAttribute("mechanics", mechanics);
            request.getRequestDispatcher("editCar.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int carId = Integer.parseInt(request.getParameter("id"));
            carDAO.delete(carId, owner.getOwnerId());
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
        CarDAO carDAO = new CarDAO();
        
        Car car = new Car();
        car.setOwnerId(owner.getOwnerId());
        car.setCarMake(request.getParameter("carMake"));
        car.setCarModel(request.getParameter("carModel"));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        car.setLicensePlate(request.getParameter("licensePlate"));
        car.setWorkDescription(request.getParameter("workDescription"));
        car.setStatus(request.getParameter("status"));
        
        String mechanicIdStr = request.getParameter("mechanicId");
        if (mechanicIdStr != null && !mechanicIdStr.isEmpty() && !"0".equals(mechanicIdStr)) {
            car.setMechanicId(Integer.parseInt(mechanicIdStr));
        }
        
        if ("add".equals(action)) {
            carDAO.add(car);
        } else if ("edit".equals(action)) {
            car.setCarId(Integer.parseInt(request.getParameter("carId")));
            carDAO.update(car);
        }
        
        response.sendRedirect("ownerDashboard");
    }
}