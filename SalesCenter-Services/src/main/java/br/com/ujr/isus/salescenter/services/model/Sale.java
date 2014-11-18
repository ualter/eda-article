package br.com.ujr.isus.salescenter.services.model;

import java.util.List;

import br.com.ujr.isus.canonical.Customer;

public class Sale {
	
	private Customer customer;
	private List<SaleItem> itens;
	
	public Sale(Customer customer, List<SaleItem> itens) {
		super();
		this.customer = customer;
		this.itens = itens;
	}
	
	
	
	


}
