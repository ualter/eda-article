package br.com.ujr.esb.services.salesservices;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.InitializingBean;
 
public class DBInitialization implements InitializingBean {
	
	public void afterPropertiesSet() throws Exception {
		
		String dbURL = "jdbc:derby:memory:salesservice;create=true";
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE TableTotalOrderByCityStream (CITY VARCHAR(255), QTDE INTEGER)");
		} 
		catch (java.sql.SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}
	}
}