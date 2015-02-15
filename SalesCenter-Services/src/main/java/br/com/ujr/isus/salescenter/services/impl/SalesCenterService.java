package br.com.ujr.isus.salescenter.services.impl;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.canonical.messages.ResponseSaveOrder;
import br.com.ujr.isus.salescenter.services.ISalesCenterService;
import br.com.ujr.isus.salescenter.services.facade.SalesCenterFacade;

@Stateless
public class SalesCenterService implements ISalesCenterService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SalesCenterService.class);
	
	@EJB
	private SalesCenterFacade facade;
	
	@POST
	@Path("/order/register/")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ResponseSaveOrder placeOrder(Order order) {
		LOGGER.info("Receiving order from customer: \"{}\"",order.getCustomer().getName());
		facade.registerSale(order);
		Integer orderNumber = order.getNumber();
		Date date = order.getDateTime();
		LOGGER.info("Generated order \"#{}\"",orderNumber.toString());
		return new ResponseSaveOrder(orderNumber,date);
	}
	
	@GET
	@Path("/hello/{nome}")
	public String ping(@PathParam("nome") String name) {
		return "Hello there, " + name + "!";
	}
	

}
