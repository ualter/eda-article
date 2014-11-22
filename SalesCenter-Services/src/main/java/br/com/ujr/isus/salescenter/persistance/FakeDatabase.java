package br.com.ujr.isus.salescenter.persistance;

import java.util.ArrayList;
import java.util.List;

import br.com.ujr.isus.canonical.Order;

/*@Fake*/
public class FakeDatabase /*implements ISaleRepository*/ {

	private List<Order> sales = new ArrayList<Order>();

	/*@Qualifier
	@Retention(RUNTIME)
	@Target({ TYPE, METHOD, FIELD, PARAMETER })
	public @interface Fake {
	}*/

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
