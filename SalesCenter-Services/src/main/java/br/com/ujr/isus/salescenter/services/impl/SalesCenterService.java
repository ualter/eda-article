package br.com.ujr.isus.salescenter.services.impl;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.salescenter.services.ISalesCenterService;
import br.com.ujr.isus.salescenter.services.facade.SalesCenterFacade;

@Stateless
public class SalesCenterService implements ISalesCenterService {
	
	private SalesCenterFacade facade = new SalesCenterFacade();
	
	@POST
	@Path("/order/register/")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Order placeOrder(Order order) {
		return facade.registerSale(order);
	}
	
	@GET
	@Path("/hello/{nome}")
	public String ping(@PathParam("nome") String name) {
		return "Hello there, " + name + "!";
	}
	

}
