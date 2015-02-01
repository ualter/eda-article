package br.com.ujr.esb.services.salesservices;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import br.com.ujr.isus.canonical.Order;

public class SaveOrderToVariable implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String restOrder = eventContext.getMessage().getPayloadAsString().replaceAll("order", "Order"); 
		ObjectMapper om = new ObjectMapper();
		om.configure(Feature.UNWRAP_ROOT_VALUE, true);
		Order order = om.readValue(restOrder, Order.class);
		eventContext.getMessage().setInvocationProperty("Order", order);
		return eventContext.getMessage().getPayload();
	}

}
