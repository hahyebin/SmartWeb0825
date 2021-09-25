package ex3_abstract;

public class SalaryMan extends Staff {
	
	private int salary;

	public SalaryMan( int salary) {
		this.salary = salary;
	}
	
	
	@Override
	public int pay() {
		return salary;
	}
	
	

	
}
