package br.com.ujr.isus.canonical;

public class OrderItem {

	private Product product;
	private int quantity;

	public OrderItem(Product product, int total) {
		super();
		this.product = product;
		this.quantity = total;
	}

	private OrderItem() {
		// only for Builder using //
	}

	public float getTotal() {
		if (this.product != null && this.product.getPrice() != null) {
			return this.product.getPrice().floatValue() * quantity;
		} else {
			return 0;
		}
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
