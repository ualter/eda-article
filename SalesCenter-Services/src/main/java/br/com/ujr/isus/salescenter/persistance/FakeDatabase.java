package br.com.ujr.isus.salescenter.persistance;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.salescenter.persistance.SaleRepositoryQualifiers.Fake;

@Fake
public class FakeDatabase implements ISaleRepository	 {

	private List<Order> sales = new ArrayList<Order>();
	
	public boolean cancel(Order sale) {
		return this.sales.remove(sale);
	}

	public boolean checkStatus(Order sale) {
		return sales.contains(sale);
	}

	public Order save(Order sale) {
		this.sales.add(sale);
		Random rnd = new Random();
		sale.setNumber(new Integer(rnd.nextInt(20)));
		return sale;
	}

}
