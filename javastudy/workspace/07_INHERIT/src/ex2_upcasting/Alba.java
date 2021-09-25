package ex2_upcasting;

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
	
	
	public Alba(String name, String dept,int payPerHour, int times) {
		super(name, dept);
		this.payPerHour = payPerHour;
		this.times = times;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println("급여: " + payPerHour * times + "원");
	}
	@Override
	public int pay() {
		return payPerHour * times;
	}
	

}
