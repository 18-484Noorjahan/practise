package com.shaziya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class First extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("email");
	String password=req.getParameter("password");
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	RequestDispatcher rd;
	if("nooritannu@gmail.com".equals(name)&&"shannu".equals(password))
	{
//	   rd=req.getRequestDispatcher("/servlet2");	
//	   rd.forward(req, resp);
		resp.sendRedirect("servlet2");
	}
	else
	{
		out.println("<h1>Invalid username</h1>");
		rd=req.getRequestDispatcher("/index.html");
		rd.include(req, resp);
	}
	
}
}
