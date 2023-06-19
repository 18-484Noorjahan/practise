package com.nooriemployeregistration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.noori.employeregistration.dao.*;
import com.noori.employeregistration.model.*;
@WebServlet(name="Details" ,urlPatterns ="/register")
public class Details extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDao;

    public void init() {
        employeeDao = new EmployeeDAO();
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {

		        String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String username = request.getParameter("username");
		        String password = request.getParameter("password");
		        String address = request.getParameter("address");
		        String contact = request.getParameter("contact");

		        Employee employee = new Employee();
		        employee.setFirstname(firstName);
		        employee.setLastname(lastName);
		        employee.setUsername(username);
		        employee.setPassword(password);
		        employee.setContact(contact);
		        employee.setAddress(address);

		        try {
		        	employeeDao.registerEmployee(employee);
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }

		        RequestDispatcher rd=  request.getRequestDispatcher("employeedetails.jsp");
		    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd= req.getRequestDispatcher("employeeregister.jsp");
		rd.forward(req, resp);
	}
} 
