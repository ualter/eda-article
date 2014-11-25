package br.com.ujr.esb.services.salesservices;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class MessageResponse {
	
	private Integer orderNumber;
	private String correlationId;
	
	
	public MessageResponse(Integer orderNumber, String correlationId) {
		this.orderNumber = orderNumber;
		this.correlationId = correlationId;
	}
	public MessageResponse() {
		
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	
	public static class Builder {
		private MessageResponse msgResponse;
		private static final Builder me = new Builder();
		
		private Builder() {
			this.msgResponse = new MessageResponse();
		}
		public static Builder Instance() {
			return me;
		}
		public Builder orderNumber(Integer orderNumber) {
			this.msgResponse.setOrderNumber(orderNumber);
			return this;
		}
		public Builder orderNumber(int orderNumber) {
			this.msgResponse.setOrderNumber(new Integer(orderNumber));
			return this;
		}
		public Builder correlationId(String correlationId) {
			this.msgResponse.setCorrelationId(correlationId);
			return this;
		}
		public MessageResponse build() {
			return this.msgResponse;
		}
		
	}
	

}
