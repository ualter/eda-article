package br.com.ujr.esb.services.salesservices;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;


public class CompoundMessageResponseObject extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {

		String uuid = "";
		String orderNumber = "";
		try {
			uuid = message.getPayloadAsString();
			orderNumber = message.getInvocationProperty("orderNumber");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MessageResponse(new Integer(orderNumber),uuid);
	}


}
