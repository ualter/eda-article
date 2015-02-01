package br.com.ujr.esb.services.salesservices;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;


public class SaveOrderNumber implements Callable{
	
	@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
		String m = eventContext.getMessageAsString();
        eventContext.getMessage().setInvocationProperty("orderNumber", m);
        return eventContext.getMessage().getPayload();
    }

}
