package br.com.ujr.isus.salescenter.persistance;

import br.com.ujr.isus.salescenter.services.model.Sale;

public interface ISaleRepository {

	public abstract boolean save(Sale sale);
	public abstract boolean cancel(Sale sale);
	public abstract boolean checkStatus(Sale sale);

}