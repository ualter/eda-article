package br.com.ujr.isus.tests.Tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ujr.isus.canonical.Customer;
import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.canonical.OrderItem;
import br.com.ujr.isus.canonical.Product;
import br.com.ujr.isus.canonical.Product.Unit;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestPersistance {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		String obj = "{   \"Order\" : 	{	  \"customer\" : {	    \"id\" : 1,	    \"name\" : \"Ualter\",	    \"city\" : \"Sao Paulo\",	    \"country\" : \"Brasil\"	  },	  \"itens\" : [ {	    \"product\" : {	      \"id\" : 1,	      \"description\" : \"HEADPHONE\",	      \"price\" : 12.30000019073486328125,	      \"unit\" : \"UNITARIO\"	    },	    \"quantity\" : 0	  }, {	    \"product\" : {	      \"id\" : 2,	      \"description\" : \"MP3 PLAYER\",	      \"price\" : 250,	      \"unit\" : \"UNITARIO\"	    },	    \"quantity\" : 0	  }, {	    \"product\" : {	      \"id\" : 3,	      \"description\" : \"BATTERIES\",	      \"price\" : 5,	      \"unit\" : \"UNITARIO\"	    },	    \"quantity\" : 0	  } ]	}}";
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		
		Order sale = mapper.readValue(obj, Order.class);
		
		EntityManagerFactory factory = null;
		try {
			factory = Persistence.createEntityManagerFactory("SalesCenterJPA");
			EntityManager em = factory.createEntityManager();
			
			em.getTransaction().begin();
			
			/**
			 * Persist Customer
			 */
			checkPersistenceCustomer(sale, em);
			/**
			 * Persist Products 
			 */
			checkPersistenceProduct(sale, em);
			
			em.persist(sale);
			em.getTransaction().commit();
			
			System.out.println("Ok");
			
		} finally {
			if ( factory != null )
				factory.close();
		}
		
	}

	private static void checkPersistenceProduct(Order sale, EntityManager em) {
		List<OrderItem> ordersItens = new ArrayList<OrderItem>();
		for(Iterator i = sale.getItens().iterator(); i.hasNext();) {
			OrderItem item = (OrderItem)i.next();
			if ( item.getProduct().getId() != null ) {
				Product product = em.find(Product.class, item.getProduct().getId());
				if ( product == null ) {
					product = item.getProduct();
					product.setId(null);
					em.persist(product);
				}
				item.setProduct(product);
			} else {
				Product product = item.getProduct();
				em.persist(product);
				item.setProduct(product);
			}
			ordersItens.add(item);
		}
		sale.setItens(ordersItens);
	}

	private static void checkPersistenceCustomer(Order sale, EntityManager em) {
		if (sale.getCustomer().getId() != null) {
			Customer c = em.find(Customer.class, sale.getCustomer().getId());
			if (c == null) {
				c = sale.getCustomer();
				c.setId(null);
				em.persist(c);
			}
			sale.setCustomer(c);
		}
	}
	
	public Order createNewOrder() {
		Customer cm = Customer.Builder.Instance().name("UALTER").city("SAO PAULO").country("BRAZIL").build();
		Product product = Product.Builder.Instance().description("MATCHBOX").unit(Unit.UNITARIO).price(10.5f).build();
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(product);
		orderItem.setQuantity(2);
			
		Order o = new Order();
		List<OrderItem> listOrderItem = new ArrayList<OrderItem>();
		listOrderItem.add(orderItem);
		o.setItens(listOrderItem);
		o.setCustomer(cm);
		o.setDate(Calendar.getInstance().getTime());
		
		return o;
		
	}

}
