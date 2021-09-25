package ex4_instance_array;

public class Company {

	private Staff[] staffs;
	private int idx;                        //직원이 추가될 인덱스 + 실제 추가된 직원의 수
		
	
	//company의 매개변수는 최대 스텝수      //staffCount는 Company의 지역변수이므로 {}밖에서 사용못함 
	public Company(int staffCount) {        // staffCount는 staffs.length와 같음 
		staffs = new Staff[staffCount];
	}
	
	
	// 직원 추가 메서드
	public void addStaff(Staff staff) {
		if(idx == staffs.length) { //full check
			System.out.println("더 이상 직원을 추가 할 수 없습니다.");
			return;
		}
		staffs[idx++] = staff;
	}
	
	// 직원 제거 메서드 
	//1. 직원이 없는데 제거하려는 경우 
	//2. 잘못된 직원번호를 입력한 경우 
	public void deletedStaff(int number) {
		if(idx == 0) {
			System.out.println("아무 직원이 없습니다.");
	       return;
		}
		if(number <= 0 || number > idx) {    // wrong number
			System.out.println("존재하지 않는 사원번호입니다.");
			return;
		}
		
		
		/*
		 * deleteStaff(1);  => deleteStaff(int number);
		 * int number =1 ;
		 *    [0]  [1]  [2]  
		 *  : s1 : s2 : s3
		 *                             idx
		 *  0 <- 1       : s2 : s2 : s3 
		 *                             idx 
		 *  1 <- 2       : s2 : s3 : s3    
		 *  
		 *  
		 *  
		 */
		
		
		for(int i =number; i<idx; i++) {
			staffs[i-1] = staffs[i];
		}
		idx--;
		staffs[idx] = null;
		
		
	}
	
	// 직원 목록 메서드
	public void staffList() {
	   System.out.println("=========직원목록============");
	   for(int i =0; i<idx; i++) {
		   System.out.println("사원번호("+ (i+1)+"), 이름 : "+staffs[i].getName()+", 부서 : "+staffs[i].getDept());
	   }
//	   
//	   for(Staff s :  staffs) {
//		   if(s != null) {             // staffs의 배열에 값이 없어도(null) 배열을 모두 출력하기 때문에 있는 값만 확인하기 위해 If문 필요
//			   System.out.println("이름 : "+s.getName() +", 부서 : "+s.getDept());
//		   }
//	   }
	   
	}
	
	
	
	
	
}
