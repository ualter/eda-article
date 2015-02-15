package br.com.ujr.esb.services.salesservices.transformers;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.canonical.messages.ResponseSaveOrder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SaveOrderResponseToVariables implements Callable{
	
	@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
		
		// Receive the ResponseSaveOrder of the SalesCenter System
		String jsonString = eventContext.getMessageAsString();
		jsonString = jsonString.replace("responseSaveOrder", "ResponseSaveOrder");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		ResponseSaveOrder responseSaveOrder = mapper.readValue(jsonString, ResponseSaveOrder.class);
		
		// Inform saved order date for the Order variable sent by the client (later it will be sent to Esper as an Event)
		Order order = (Order)eventContext.getMessage().getInvocationProperty("order");
		order.setDate(responseSaveOrder.getDate());
		
		// Set the variables for the flow message
		eventContext.getMessage().setInvocationProperty("responseSaveOrder", responseSaveOrder);
		eventContext.getMessage().setInvocationProperty("orderNumber", String.valueOf(responseSaveOrder.getNumber()));
		eventContext.getMessage().setInvocationProperty("date", responseSaveOrder.getDate().toString());
        
        return eventContext.getMessage().getPayload();
    }

}
