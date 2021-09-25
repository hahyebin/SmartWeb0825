package ex4_instance_array;

public class Staff {
	
	
	private String name;
	private String dept;
	
	
	//default constructor
	public Staff() {
		
	}
	
	// constructor
	public Staff(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	
	
	
	
}
