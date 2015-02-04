package br.com.ujr.isus.sales.center.services.mini.js.bam;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/events","/check"})
public class MiniJsBamController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//resp.getWriter().write("Hello, here is a Servlet" + " by " + req.getServletPath());
		
		MiniJsBamServices services = new MiniJsBamServices();
		String jsonString = services.getTotalOrderByCity();
		resp.getWriter().write(jsonString);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
	}

}
