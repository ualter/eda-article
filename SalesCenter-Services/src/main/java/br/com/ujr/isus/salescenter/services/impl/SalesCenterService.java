package br.com.ujr.isus.salescenter.services.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.salescenter.services.ISalesCenterService;
import br.com.ujr.isus.salescenter.services.facade.SalesCenterFacade;

@Path("/salescenter")
public class SalesCenterService implements ISalesCenterService {
	
	private SalesCenterFacade facade = new SalesCenterFacade();
	
	@POST
	@Path("/order/register")
	@Consumes("application/json")
    @Produces({"application/json", "application/xml"})
	public Order placeOrder(Order order) {
		return facade.registerSale(order);
	}
	
	@GET
	@Path("/order/{name}")
	@Produces({"application/json","application/xml"})
	public String ping(String name) {
		return "Hello there " + name;
	}
	

}
