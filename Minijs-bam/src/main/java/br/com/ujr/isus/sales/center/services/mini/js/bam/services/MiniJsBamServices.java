package br.com.ujr.isus.sales.center.services.mini.js.bam.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.ujr.isus.canonical.events.TotalOrderByCity;
import br.com.ujr.isus.canonical.events.TotalOrderByDate;
import br.com.ujr.isus.canonical.events.TotalOrderByTimeFrame;
import br.com.ujr.isus.sales.center.services.mini.js.bam.db.DataSource;

@Named
public class MiniJsBamServices  {

	public TotalOrderByCity[] getTotalOrderByCity() {
		List<TotalOrderByCity> listTotalOrderByCities = new ArrayList<TotalOrderByCity>();
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.prepareStatement("SELECT * FROM TableTotalOrderByCityStream");
			
			ResultSet rs = st.executeQuery();
			while ( rs.next() ) {
				String city = rs.getString(1);
				int    qtde = rs.getInt(2);
				
				TotalOrderByCity t = TotalOrderByCity.Builder.Instance()
											.city(city)
											.total(qtde)
											.build();
				listTotalOrderByCities.add(t);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if ( st != null )   st.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		TotalOrderByCity[] result = new TotalOrderByCity[listTotalOrderByCities.size()];
		listTotalOrderByCities.toArray(result);
		
		return result;
	}
	
	public TotalOrderByDate[] getTotalOrderByDate() {
		List<TotalOrderByDate> listTotalOrderByDates = new ArrayList<TotalOrderByDate>();
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.prepareStatement("SELECT * FROM TableTotalOrderByDateStream");
			
			ResultSet rs = st.executeQuery();
			while ( rs.next() ) {
				int date = rs.getInt(1);
				int qtde = rs.getInt(2);
				
				TotalOrderByDate t = TotalOrderByDate.Builder.Instance()
											.date(date)
											.total(qtde)
											.build();
				listTotalOrderByDates.add(t);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if ( st != null )   st.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		TotalOrderByDate[] result = new TotalOrderByDate[listTotalOrderByDates.size()];
		listTotalOrderByDates.toArray(result);
		
		return result;
	}
	
	public TotalOrderByDate[] getTotalOrderByDate(int dateRequest) {
		List<TotalOrderByDate> listTotalOrderByDates = new ArrayList<TotalOrderByDate>();
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.prepareStatement("SELECT * FROM TableTotalOrderByDateStream WHERE Date = ?");
			st.setInt(1, dateRequest);
			
			ResultSet rs = st.executeQuery();
			while ( rs.next() ) {
				int date = rs.getInt(1);
				int qtde = rs.getInt(2);
				TotalOrderByDate t = TotalOrderByDate.Builder.Instance()
											.date(date)
											.total(qtde)
											.build();
				listTotalOrderByDates.add(t);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if ( st != null )   st.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		TotalOrderByDate[] result = new TotalOrderByDate[listTotalOrderByDates.size()];
		listTotalOrderByDates.toArray(result);
		
		return result;
	}
	
	/**
	 * Receive the timeFrames separated by underline, like this:  10secs_30secs, and then
	 * we have to convert to: '10secs','30secs'
	 * @param timeFrame
	 * @return
	 */
	public TotalOrderByTimeFrame[] getTotalOrderByTimeFrame(String timeFrame) {
		List<TotalOrderByTimeFrame> listTotalOrderByTimeFrame = new ArrayList<TotalOrderByTimeFrame>();
		
		if ( timeFrame.contains("_") ) {
			String times[] = timeFrame.split("_");
			timeFrame = "";
			for(String t : times) {
				timeFrame += (timeFrame.length() > 0) ? "," : ""; 
				timeFrame += "'" + t + "'";
			}
		}
		
		Connection conn = null;
		Statement st = null;
		try {
			conn = DataSource.getInstance().getConnection();
			String sql = "SELECT * FROM TableTotalOrderByTimeFrameStream WHERE TIMEFRAME IN (" + timeFrame + ")";
			st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while ( rs.next() ) {
				String tf         = rs.getString(1);
				int    qtdeTotal  = rs.getInt(2);
				float  valueTotal = rs.getFloat(3);
				TotalOrderByTimeFrame t = TotalOrderByTimeFrame.Builder.Instance()
											.timeFrame(tf)
											.qtdeTotal(qtdeTotal)
											.valueTotal(valueTotal)
											.build();
				listTotalOrderByTimeFrame.add(t);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if ( st != null )   st.close();
				if ( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		TotalOrderByTimeFrame[] result = new TotalOrderByTimeFrame[listTotalOrderByTimeFrame.size()];
		listTotalOrderByTimeFrame.toArray(result);
		
		return result;
	}

}
