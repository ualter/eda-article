package br.com.ujr.isus.salescenter.persistance;

import br.com.ujr.isus.canonical.Order;

public interface ISaleRepository {

	public abstract Order save(Order sale);
	public abstract boolean cancel(Order sale);
	public abstract boolean checkStatus(Order sale);
	
}