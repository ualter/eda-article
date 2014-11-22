package br.com.ujr.isus.salescenter.persistance;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Random;

import javax.inject.Named;
import javax.inject.Qualifier;

import br.com.ujr.isus.canonical.Order;

/*@Default
@Hsql*/
@Named
public class HsqldbDatabase implements ISaleRepository {

	/*@Qualifier
	@Retention(RUNTIME)
	@Target({TYPE, METHOD, FIELD, PARAMETER})
	public @interface Hsql {}*/
	
	public Order save(Order sale) {
		Random rnd = new Random(65000);
		sale.setNumber(new Integer(rnd.nextInt()));
		return sale;
	}

	public boolean cancel(Order sale) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkStatus(Order sale) {
		// TODO Auto-generated method stub
		return false;
	}

}
