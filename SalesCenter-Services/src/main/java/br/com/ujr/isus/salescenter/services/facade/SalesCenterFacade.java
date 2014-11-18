package br.com.ujr.isus.salescenter.services.facade;

import javax.inject.Inject;

import br.com.ujr.isus.salescenter.persistance.ISaleRepository;
import br.com.ujr.isus.salescenter.persistance.HsqldbDatabase.Hsql;
import br.com.ujr.isus.salescenter.services.model.Sale;

public class SalesCenterFacade {
	
	@Inject @Hsql ISaleRepository repository;
	
	public void registerSale(Sale sale) {
		repository.save(sale);
	}
	
	public boolean getStatusSale(Sale sale) {
		return repository.checkStatus(sale);
	}
	
	public boolean cancelSale(Sale sale) {
		return repository.cancel(sale);
	}

}
