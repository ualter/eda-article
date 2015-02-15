package br.com.ujr.isus.canonical.messages;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseSaveOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer number;
	private Date date;

	public ResponseSaveOrder() {
	}

	public ResponseSaveOrder(Integer number, Date date) {
		super();
		this.number = number;
		this.date = date;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
