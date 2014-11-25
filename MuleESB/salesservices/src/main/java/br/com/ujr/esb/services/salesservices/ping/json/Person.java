package br.com.ujr.esb.services.salesservices.ping.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Person {
	
	private String name;
	private String dob;

	private List<EmailAddress> emailAddresses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
}