import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transport.http.ReleasingInputStream;

import br.com.ujr.esb.services.salesservices.MessageResponse;

public class CompoundMessageResponseObject extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		

		String uuid = "";
		try {
			uuid = message.getPayloadAsString();
			
			ReleasingInputStream i = message.getInvocationProperty("orderNumber");
			
			/*byte[] b = new byte[2];
			System.out.println(i.available());
			i.read(b);*/
			
			String s = "";
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		
		
		return new MessageResponse(new Integer("2"),uuid);
	}

	// convert InputStream to String
	private static String getStringFromInputStream(ReleasingInputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}
