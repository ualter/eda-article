package br.com.ujr.isus.canonical;


public class OrdemItem {
	
	private Product product;
	private int total;
	
	public OrdemItem(Product product, int total) {
		super();
		this.product = product;
		this.total = total;
	}
	
	public float getTotal() {
		return this.product.getPrice().floatValue() * total;
	}

}
