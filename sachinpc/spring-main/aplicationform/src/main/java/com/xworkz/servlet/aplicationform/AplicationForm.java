package com.xworkz.servlet.aplicationform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(loadOnStartup = 2,urlPatterns = "/mall")
public class AplicationForm extends HttpServlet{
	
	public AplicationForm() {

	System.out.println("aplicationform is created");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println("just service method is invoked");
String parameter = req.getParameter("name");
String parameter2 = req.getParameter("mn");
System.out.println(parameter2);
System.out.println(parameter);
	resp.setContentType("text/html");
	PrintWriter writer = resp.getWriter();
	writer.append("<html><body><h1>i love my mom jyothi</h1>").append(parameter).append(parameter2)
			.append( "</body></html>");
	
	}
	

}
