package br.com.ujr.isus.canonical;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1327693356429477786L;
	private Integer number;
	private Customer customer;
	private List<OrderItem> itens;
	
	public Order(Customer customer, List<OrderItem> itens) {
		super();
		this.customer = customer;
		this.itens = itens;
	}
	public Order() {
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void setItens(List<OrderItem> itens) {
		this.itens = itens;
	}
	
	


}
