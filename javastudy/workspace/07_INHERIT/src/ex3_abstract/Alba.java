package ex3_abstract;

public class Alba extends Staff {
	
	private int times;
	private int payPerHour;
	
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}
	
	
	public Alba(int payPerHour, int times) {
		this.payPerHour = payPerHour;
		this.times = times;
	}
	

	@Override
	public int pay() {
		return payPerHour * times;
	}
	

}
