package br.com.ujr.esb.services.salesservices.transformers;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import br.com.ujr.esb.services.salesservices.endpoint.MessageResponse;


public class CompoundMessageResponseObject extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {

		String uuid = "";
		String orderNumber = "";
		String date = "";
		try {
			uuid = message.getPayloadAsString();
			orderNumber = message.getInvocationProperty("orderNumber");
			date = message.getInvocationProperty("date");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new MessageResponse(new Integer(orderNumber),uuid,date);
	}


}
