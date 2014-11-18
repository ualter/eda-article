package br.com.ujr.isus.salescenter.persistance;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.inject.Default;
import javax.inject.Qualifier;

import br.com.ujr.isus.salescenter.persistance.HsqldbDatabase.Hsql;
import br.com.ujr.isus.salescenter.services.model.Sale;

@Default
@Hsql
public class HsqldbDatabase implements ISaleRepository {

	@Qualifier
	@Retention(RUNTIME)
	@Target({TYPE, METHOD, FIELD, PARAMETER})
	public @interface Hsql {}
	
	public boolean save(Sale sale) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean cancel(Sale sale) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkStatus(Sale sale) {
		// TODO Auto-generated method stub
		return false;
	}

}
