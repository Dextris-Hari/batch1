package com.xworkz.servlets.fire;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = ("/maya"))
public class FireServlets extends HttpServlet {
	public FireServlets() {
System.out.println("FireServlets is created");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("invoked");
		String parameter = req.getParameter("name");
		String parameter2 = req.getParameter("company");
		String parameter3 = req.getParameter("package");
		System.out.println("name:".concat(parameter));
		System.out.println("company:".concat(parameter2));
		System.out.println("package:".concat(parameter3));
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.append("<html>")
		.append("<body>")
		.append("<h1>")
		.append("manoj is done")
		.append("</br>")
		.append("alias name:")
		.append(parameter)
		.append("</br>")
		.append("company")
		.append(parameter2)
		.append("</br>")
		.append("package")
		.append(parameter3)
		.append("</br>")
		.append("</h1>")
		.append("</body>")
		.append("</html>");
		
	}

}
