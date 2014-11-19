package br.com.ujr.isus.canonical;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
	
	private static final long serialVersionUID = 1327693356429477786L;
	private Integer number;
	private Customer customer;
	private List<OrdemItem> itens;
	
	public Order(Customer customer, List<OrdemItem> itens) {
		super();
		this.customer = customer;
		this.itens = itens;
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

	public List<OrdemItem> getItens() {
		return itens;
	}

	public void setItens(List<OrdemItem> itens) {
		this.itens = itens;
	}
	
	


}
