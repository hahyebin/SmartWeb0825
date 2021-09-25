package ex2_upcasting;

public class Company {
	private String name;
	private Staff[] staffs;
	private int idx;
	
	
	public Company(String name, int StaffCount) {
		this.name = name;
		staffs = new Staff[StaffCount];
	}
	
	public void addStaff(Staff staff) {
		if(idx == staffs.length) {
			System.out.println("FULL");
			return;
		}
		staffs[idx++] = staff;
	}
	
	public void companyInfo() {
		System.out.println("회사명 : " +name);
		System.out.println("==직원목록==");
		for(int i =0; i<idx; i++) {
			staffs[i].info();
		}
	}	

	public void payInfo() {
		int total =0;
		for(int i=0; i<idx; i++) {
			total += staffs[i].pay();
		}
		System.out.println("총 급여 : " +total);
	}

}
