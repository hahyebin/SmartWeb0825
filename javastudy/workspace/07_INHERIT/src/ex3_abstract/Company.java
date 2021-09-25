package ex3_abstract;

public class Company {

	private Staff[] staffs;
	private int idx;
	
	
	public Company( int StaffCount) {
		staffs = new Staff[StaffCount];
	}
	
	public void addStaff(Staff staff) {
		if(idx == staffs.length) {
			System.out.println("FULL");
			return;
		}
		staffs[idx++] = staff;
	}
	

	public void payInfo() {
		int total =0;
		for(int i=0; i<idx; i++) {
			total += staffs[i].pay();
		}
		System.out.println("총 급여 : " +total);
	}

}
