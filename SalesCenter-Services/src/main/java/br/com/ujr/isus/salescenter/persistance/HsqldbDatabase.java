package br.com.ujr.isus.salescenter.persistance;

import java.util.Random;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.salescenter.persistance.SaleRepositoryQualifiers.Hsql;

@Hsql
public class HsqldbDatabase implements ISaleRepository {

	public Order save(Order sale) {
		Random rnd = new Random();
		sale.setNumber(new Integer(rnd.nextInt(65000)));
		return sale;
	}

	public boolean cancel(Order sale) {
		return false;
	}

	public boolean checkStatus(Order sale) {
		return false;
	}

}
