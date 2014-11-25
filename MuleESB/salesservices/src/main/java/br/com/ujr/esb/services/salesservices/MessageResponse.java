package br.com.ujr.esb.services.salesservices;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageResponse {
	
	private Integer orderNumber;
	private String correlationId;
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
	
	

}
