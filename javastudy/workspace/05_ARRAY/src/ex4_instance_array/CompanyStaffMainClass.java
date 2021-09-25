package ex4_instance_array;

public class CompanyStaffMainClass {

	public static void main(String[] args) {


		
		Company company = new Company(3);
		
		
		
		company.addStaff(new Staff("이사원","총무"));
		company.addStaff(new Staff("박과장","인사"));
		company.addStaff(new Staff("최과장","홍보"));
	    
        company.staffList();
        
		company.deletedStaff(3);
		
		
		company.staffList();

	}
}
