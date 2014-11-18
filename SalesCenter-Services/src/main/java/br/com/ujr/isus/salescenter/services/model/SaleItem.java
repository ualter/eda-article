package br.com.ujr.isus.salescenter.services.model;

import br.com.ujr.isus.canonical.Product;

public class SaleItem {
	
	private Product product;
	private int total;
	
	public SaleItem(Product product, int total) {
		super();
		this.product = product;
		this.total = total;
	}
	
	public float getTotal() {
		return this.product.getPrice().floatValue() * total;
	}

}
