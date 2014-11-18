package br.com.ujr.isus.canonical;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 4225372889694816429L;
	private Integer id;
	private String description;
	private BigDecimal price;
	private Enum<Unit> unit;
	
	public Product(Integer id, String description, BigDecimal price, Enum<Unit> unit) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.unit = unit;
	}
	private Product() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Enum<Unit> getUnit() {
		return unit;
	}
	public void setUnit(Enum<Unit> unit) {
		this.unit = unit;
	}

	public enum Unit {
		LITRO,PACOTE,UNITARIO
	}
	
	/**
	 * Builder (Pattern)
	 * Usage: 
	 * Produto product = Builder.Instance()
	 *							.id(2)
	 *							.description("teste")
	 *							.build();
	 * @author Ualter Jr.
	 */
	public static class Builder {
		private Product product;
		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}
		private Builder() {
			this.product = new Product();
		}
		public Builder id(Integer id) {
			this.product.setId(id);
			return this;
		}
		public Builder id(int id) {
			this.product.setId(new Integer(id));
			return this;
		}
		public Builder description(String description) {
			this.product.setDescription(description);
			return this;
		}
		public Builder price(BigDecimal price) {
			this.product.setPrice(price);
			return this;
		}
		public Builder price(float price) {
			this.product.setPrice(new BigDecimal(price));
			return this;
		}
		public Builder unit(Enum<Unit> unit) {
			this.product.setUnit(unit);
			return this;
		}
		public Product build() {
			return this.product;
		}
	}

}
