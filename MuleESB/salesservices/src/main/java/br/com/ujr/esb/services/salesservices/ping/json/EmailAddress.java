package br.com.ujr.esb.services.salesservices.ping.json;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class EmailAddress implements Serializable {
	
	private String type;
	private String address;
	
	public EmailAddress() {
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
