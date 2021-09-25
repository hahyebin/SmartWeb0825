package exam;

public class Regular extends Employee {
	
	private int salary;

	public Regular(int empNo, String name, String department, int salary) {
		super(empNo, name, department);
        this.salary = salary;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println(", 급여 : "+ salary);
	}
}
