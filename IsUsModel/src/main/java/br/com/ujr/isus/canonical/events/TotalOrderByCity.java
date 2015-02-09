package br.com.ujr.isus.canonical.events;


public class TotalOrderByCity {
	
	private String city;
	private long total;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	public static class Builder {
		private TotalOrderByCity target;
		
		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}
		
		private Builder() {
			this.target = new TotalOrderByCity();
		}
		
		public Builder total(int qtde) {
			this.target.setTotal(qtde);
			return this;
		}
		
		public Builder city(String city) {
			this.target.setCity(city);
			return this;
		}
		
		public TotalOrderByCity build() {
			return target;
		}
		
	}
	

}
