package br.com.ujr.isus.salescenter.persistance;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

public class SaleRepositoryQualifiers {
	
	@Qualifier
	@Retention(RUNTIME)
	@Target({TYPE, METHOD, FIELD, PARAMETER})
	public @interface MySQL {}
	
	@Qualifier
	@Retention(RUNTIME)
	@Target({ TYPE, METHOD, FIELD, PARAMETER })
	public @interface Fake {}

}
