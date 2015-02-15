package br.com.ujr.isus.canonical;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Customer")
@XmlRootElement
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String city;
	private String country;

	public Customer(Integer id, String name, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	private Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Builder (Pattern) 
	 * 
	 * @author Ualter Jr.
	 */
	public static class Builder {
		private Customer customer;

		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}

		private Builder() {
			this.customer = new Customer();
		}

		public Builder id(Integer id) {
			this.customer.setId(id);
			return this;
		}

		public Builder id(int id) {
			this.customer.setId(new Integer(id));
			return this;
		}

		public Builder name(String name) {
			this.customer.setName(name);
			return this;
		}

		public Builder city(String city) {
			this.customer.setCity(city);
			return this;
		}

		public Builder country(String country) {
			this.customer.setCountry(country);
			return this;
		}
		public Customer build() {
			return this.customer;
		}
	}

}
