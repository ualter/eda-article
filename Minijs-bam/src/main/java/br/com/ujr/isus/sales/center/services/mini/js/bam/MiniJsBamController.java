package br.com.ujr.isus.sales.center.services.mini.js.bam;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ujr.isus.sales.center.services.mini.js.bam.services.MiniJsBamServices;

@Named
@WebServlet(name = "MiniJsBamController", urlPatterns = { "/events", "/ping" }, loadOnStartup = 1)
public class MiniJsBamController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/*@Inject
	private MiniJsBamServices services;*/
	
	/*@Resource
	private ServletContext servletContext;*/

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String path = req.getServletPath();

		switch (path) {
			case "/events":
				break;
			case "/ping":
				//resp.getWriter().write( services.ping());
				break;
			default:
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
	}

}
