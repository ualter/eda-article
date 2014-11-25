package br.com.ujr.esb.services.salesservices;

import javax.xml.bind.annotation.XmlRootElement;

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
	

}
