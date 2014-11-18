package br.com.ujr.isus.salescenter.persistance;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Qualifier;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.salescenter.persistance.FakeDatabase.Fake;

@Fake
public class FakeDatabase implements ISaleRepository {

	private List<Order> sales = new ArrayList<Order>();

	@Qualifier
	@Retention(RUNTIME)
	@Target({ TYPE, METHOD, FIELD, PARAMETER })
	public @interface Fake {
	}

	public boolean cancel(Order sale) {
		return this.sales.remove(sale);
	}

	public boolean checkStatus(Order sale) {
		return sales.contains(sale);
	}

	public Order save(Order sale) {
		this.sales.add(sale);
		return sale;
	}

}
