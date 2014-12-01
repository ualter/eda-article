package br.com.ujr.esb.services.salesservices;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.ujr.esb.services.salesservices.MessageResponse.Builder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class MessageRequest {
	
	
	private br.com.ujr.isus.canonical.Order order;

	public br.com.ujr.isus.canonical.Order getOrder() {
		return order;
	}

	public void setOrder(br.com.ujr.isus.canonical.Order order) {
		this.order = order;
	}
	
	public static class Builder {
		private MessageRequest messageRequest = new MessageRequest();
		
		private Builder() {
		}
		
		public static Builder newInstance() {
			return new Builder();
		}
		
		public Builder order(br.com.ujr.isus.canonical.Order order) {
			this.messageRequest.setOrder(order);
			return this;
		}
		
		public MessageRequest build() {
			return messageRequest;
		}
		
	}

}
