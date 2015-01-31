import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.transport.http.ReleasingInputStream;


public class Test implements Callable{
	
	@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
 
        @SuppressWarnings("unused")
		String s = eventContext.getMessage().getInvocationProperty("orderNumber");
        
        return eventContext.getMessage().getPayload();
    }

}
