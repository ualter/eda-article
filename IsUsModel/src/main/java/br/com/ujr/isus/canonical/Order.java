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


}
