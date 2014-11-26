package br.com.ujr.esb.services.salesservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ujr.esb.services.salesservices.ping.json.Person;
import br.com.ujr.isus.canonical.Order;

@Path("/rest")
public class ReceiveSalesOrder {

	@POST
	@Path("/sales/order/")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//public Response receiveSalesOrder(br.com.ujr.isus.canonical.Order order) {
	public Order receiveSalesOrder(MessageRequest request) {
		br.com.ujr.isus.canonical.Order order = request.getOrder();
		System.out.println(order.getCustomer().getName());
		order.setNumber(new Integer(-1));
		return request.getOrder();
		/*return MessageResponse.Builder.Instance()
								.orderNumber(order.getNumber())
								.correlationId("2")
								.build();*/
	}
	
	
	@GET
	@Path("/hello/{nome}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String hello(@PathParam("nome") String name, @QueryParam("param") String param) {
		return "Hello " + name + ", " + param;
	}
	
	@POST
	@Path("/sales/person/")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response receivePerson(Person person) {
		person.setName("Ualter");
		System.out.println(person);
		return Response.ok(person).build();
	}
	

}
