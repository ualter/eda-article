package br.com.ujr.isus.canonical;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Product")
@XmlRootElement
public class Product implements Serializable {
	
	private static final long serialVersionUID = 4225372889694816429L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String description;
	
	private float price = 0;
	
	private Product.Unit unit = Product.Unit.UNITARIO; 
	
	public Product(Integer id, String description, float price, Product.Unit unit) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public Product.Unit getUnit() {
		return unit;
	}
	public void setUnit(Product.Unit unit) {
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
		public Builder price(float price) {
			this.product.setPrice(price);
			return this;
		}
		public Builder unit(Product.Unit unit) {
			this.product.setUnit(unit);
			return this;
		}
		public Product build() {
			return this.product;
		}
	}

}
