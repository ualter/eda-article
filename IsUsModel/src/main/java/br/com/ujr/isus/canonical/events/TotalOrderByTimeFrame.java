package br.com.ujr.isus.canonical.events;


public class TotalOrderByTimeFrame {
	
	private String timeFrame;
	private long qtdeTotal;
	private float valueTotal;

	public String getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}
	public long getQtdeTotal() {
		return qtdeTotal;
	}
	public void setQtdeTotal(long qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}
	public float getValueTotal() {
		return valueTotal;
	}
	public void setValueTotal(float valueTotal) {
		this.valueTotal = valueTotal;
	}

	public static class Builder {
		private TotalOrderByTimeFrame target;
		
		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}
		
		private Builder() {
			this.target = new TotalOrderByTimeFrame();
		}
		
		public Builder qtdeTotal(int qtde) {
			this.target.setQtdeTotal(qtde);
			return this;
		}
		
		public Builder valueTotal(float value) {
			this.target.setValueTotal(value);
			return this;
		}
		
		public Builder timeFrame(String timeFrame) {
			this.target.setTimeFrame(timeFrame);
			return this;
		}
		
		public TotalOrderByTimeFrame build() {
			return target;
		}
		
	}
	

}
