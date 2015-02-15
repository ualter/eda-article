package br.com.ujr.isus.salescenter.services.facade;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ujr.isus.canonical.Order;
import br.com.ujr.isus.salescenter.persistance.ISaleRepository;
import br.com.ujr.isus.salescenter.persistance.SaleRepositoryQualifiers.MySQL;

@Stateless
public class SalesCenterFacade {
	
	@Inject @MySQL
	ISaleRepository repository;
	
	public Order registerSale(Order order) {
		return repository.save(order);
	}
	
	public boolean getStatusSale(Order order) {
		return repository.checkStatus(order);
	}
	
	public boolean cancelSale(Order order) {
		return repository.cancel(order);
	}

}
