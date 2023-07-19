package hanumant.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/water")
public class MoonServlets extends HttpServlet {

	public MoonServlets() {
		System.out.println("manoj is supper");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("server method is create");

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.append("<html><body bgcolor color='red'><h1>manaj is developer and human").append("</h1></body><html>");
	}

}
