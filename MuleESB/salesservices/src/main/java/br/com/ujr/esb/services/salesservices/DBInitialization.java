package br.com.ujr.esb.services.salesservices;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.InitializingBean;
 
public class DBInitialization implements InitializingBean {
	
	public void afterPropertiesSet() throws Exception {
		
		String dbURL = "jdbc:derby:memory:blogdemo;create=true";
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE table1 (Name VARCHAR(255), External_ID__c VARCHAR(255), Value__c INTEGER, Last_Modified TIMESTAMP)");
			stmt.executeUpdate("CREATE TABLE table2 (somecolumn VARCHAR(20), somecode VARCHAR(80))");
		} 
		catch (java.sql.SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}
	}
}