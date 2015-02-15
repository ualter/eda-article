package br.com.ujr.esb.services.salesservices.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.InitializingBean;

public class DBInitialization implements InitializingBean {

	public void afterPropertiesSet() throws Exception {
		/*String dbURL = "jdbc:mysql://localhost:3306/DbEvents?user=esper&password=esper"; 
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE TableTotalOrderByCityStream (CITY VARCHAR(255), QTDE INTEGER)");
		} catch (java.sql.SQLException sqle) {
			throw sqle;
		}*/
	}
}