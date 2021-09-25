package exam;
// 67/70
import java.util.ArrayList;
import java.util.List;

public class Group {
	
	
    private String groupName;
    private List<Employee> emplist;
    
	public Group(String groupName) {
		this.groupName = groupName;  // 틀린부  -> 그룹네임명시하기!!!!!
		emplist = new ArrayList<Employee>();
	  
	} 
//	 내가 한거 
//	public void hireEmployee(Employee employee) {
//			emplist.add(employee);	
//			
//	}
	
	// 답
	public void hireEmployee(Employee employee) {
		emplist.add(employee);	
	   System.out.println(employee.getEmpNo() +" 번 사원번호가 등록되었습니다.");
		
}
	public void dropEmployee(int empNo) {
		int length = emplist.size();
		System.out.println("=== 사원삭제 ====");
		for(Employee em : emplist) {
			if(em.getEmpNo() ==empNo) {
				emplist.remove(em);
				 System.out.println("삭제된 사원 번호 : "+empNo);
				return;
			}
		}		
	}
	public void info() {
		System.out.println("=== 사원 조회 ====");
		System.out.println("그룹명 : "+ groupName);
		System.out.println("전체사원 : " +emplist.size() + "명");
		for(Employee employee : emplist) {
			employee.info();
		}
	}
}
