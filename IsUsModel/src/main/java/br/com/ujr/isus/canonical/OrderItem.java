package br.com.ujr.isus.canonical;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="OrderItem")
@XmlRootElement
public class OrderItem {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name="id_product")
	private Product product;
	
	private int quantity;

	public OrderItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public OrderItem() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static class Builder {
		private OrderItem orderItem;

		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}

		private Builder() {
			this.orderItem = new OrderItem();
		}

		public Builder product(Product product) {
			this.orderItem.setProduct(product);
			return this;
		}

		public Builder product(int id) {
			this.orderItem.setProduct(Product.Builder.Instance().id(id)
					.build());
			return this;
		}
		
		public Builder product(int id, String description, float value, Product.Unit unit) {
			this.orderItem.setProduct(Product.Builder.Instance().id(id)
					                                             .description(description)
					                                             .price(value)
					                                             .unit(unit).build());
			return this;
		}

		public Builder quantity(int qtde) {
			this.orderItem.setQuantity(qtde);
			return this;
		}

		public OrderItem build() {
			return this.orderItem;
		}
	}

}
