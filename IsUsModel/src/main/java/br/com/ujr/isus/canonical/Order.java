package br.com.ujr.isus.canonical;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Orders")
@XmlRootElement
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1327693356429477786L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer number;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="id_customer")
	private Customer customer;
	
	@OneToMany(cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name="id_order")
	private List<OrderItem> itens;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date")
	private Date dateTime;
	
	public Order(Customer customer, List<OrderItem> itens) {
		super();
		this.customer = customer;
		this.itens = itens;
	}
	public Order() {
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

	public List<OrderItem> getItens() {
		return itens;
	}

	public void setItens(List<OrderItem> itens) {
		this.itens = itens;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date date) {
		this.dateTime = date;
	}
	
	public int getDate() {
		if ( this.dateTime != null ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(this.dateTime);
			return Integer.parseInt(date);
		}
		return 0;
	}
	

}
