package br.com.ujr.isus.canonical.events;




public class TotalOrderByDate {
	
	private int date;
	private long total;
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	public static class Builder {
		private TotalOrderByDate target;
		
		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}
		
		private Builder() {
			this.target = new TotalOrderByDate();
		}
		
		public Builder total(int qtde) {
			this.target.setTotal(qtde);
			return this;
		}
		
		public Builder date(int city) {
			this.target.setDate(city);
			return this;
		}
		
		public TotalOrderByDate build() {
			return target;
		}
		
	}
}
