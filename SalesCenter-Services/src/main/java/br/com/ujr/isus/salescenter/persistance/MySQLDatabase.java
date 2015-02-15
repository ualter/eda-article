package br.com.ujr.isus.salescenter.persistance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ujr.isus.canonical.Customer;
import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.canonical.OrderItem;
import br.com.ujr.isus.canonical.Product;
import br.com.ujr.isus.salescenter.persistance.SaleRepositoryQualifiers.MySQL;

@MySQL
public class MySQLDatabase implements ISaleRepository {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(MySQLDatabase.class);

	public Order save(Order sale) {
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
			sale.setDate(Calendar.getInstance().getTime());
			em.persist(sale);
			em.getTransaction().commit();

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new RuntimeException(e);
		} finally {
			factory.close();
		}
		return sale;
	}

	public boolean cancel(Order sale) {
		return false;
	}

	public boolean checkStatus(Order sale) {
		return false;
	}

	private void checkPersistenceProduct(Order sale, EntityManager em) {
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

}
