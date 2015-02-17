package br.com.ujr.isus.sales.center.services.mini.js.bam;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Named;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ujr.isus.sales.center.services.mini.js.bam.services.MiniJsBamServices;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Named
@WebServlet(name = "MiniJsBamController", urlPatterns = { "/totalOrderByCities", "/totalOrderByDate","/ping" }, loadOnStartup = 1)
public class MiniJsBamController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private MiniJsBamServices services = new MiniJsBamServices();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String path = req.getServletPath();
		
		String jsonContent = "";
		switch (path) {
			case "/totalOrderByCities":
				jsonContent = this.transformToJson ( this.services.getTotalOrderByCity() );
				break;
			case "/totalOrderByDate":
				int dateRequest = Integer.parseInt(req.getParameter("date"));
				jsonContent = this.transformToJson ( this.services.getTotalOrderByDate(dateRequest));
				break;
			case "/ping":
				jsonContent = this.ping();
				break;
			default:
				break;
		}
		resp.getWriter().write( jsonContent );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().write("Sorry! We are working only with GET for the sake of simplicity, this is not a real project.");
	}
	
	private String ping() {
		ArrayList<String> str = new ArrayList<String>();
		str.add("UALTER");
		return this.transformToJson(str);
	}
	
	private String transformToJson(Object obj) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(SerializationFeature.CLOSE_CLOSEABLE);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/*private class Message {
		private String transaction;
		private Object payload;
		private Message() {
		}
		public String getTransaction() {
			return transaction;
		}
		public void setTransaction(String transaction) {
			this.transaction = transaction;
		}
		public Object getPayload() {
			return payload;
		}
		public void setPayload(Object payload) {
			this.payload = payload;
		}
	}*/

}
