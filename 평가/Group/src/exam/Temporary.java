package exam;

public class Temporary extends Employee {

	   private int hourPay;
	   private int workTimes;
	   
	   
	public Temporary(int empNo, String name, String department, int hourPay, int workTimes) {
		super(empNo, name, department);
		this.hourPay= hourPay;
		this.workTimes = workTimes;	
	}
	@Override
	public void info() {
		super.info();
		System.out.println(", 급여 : "+ hourPay*workTimes);
	}
}


