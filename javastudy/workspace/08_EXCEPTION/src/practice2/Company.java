package practice2;


import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.AllArgsConstructor;

public class Company {
   private Scanner sc = new Scanner(System.in);
   private Staff[] staffs;
   private int idx;
   
   public Company(int staffCount) {
	     staffs = new Staff[staffCount];
   }
   
   public void addStaff() {
	   //메소드 내부에서 직접 처리한 방식 
	   try {
	    System.out.println("**사원추가**");
	    System.out.print("사원번호 >> ");
	    long staffNo = sc.nextLong();
	    System.out.print("사원이름 입력 > ");
	    String name = sc.next();
	    System.out.print("근무부서 입력 >> ");
	    String dept = sc.next();
	    staffs[idx++] = new Staff(staffNo, name, dept);
	   } catch (InputMismatchException e) {
		   System.out.println("사원번호는 정수형식입니다.");
	   } catch (ArrayIndexOutOfBoundsException e ) {
		   System.out.println("더 이상 사원을 추가 할 수 없습니다."); 
	   }
   }
   
   public void deleteStaff() {
	   //사원번호를 입력받아서 해당 사원 삭제 
	   //deleteStaff() 메소드를 호출하는 곳에서 예외처리
	   
	   System.out.println("***사원 삭제***");
	   System.out.print("삭제할 사원번호 >> ");
	   long staffNo = sc.nextLong();
	   
	  for(int i=0; i<idx; i++) {
		  if(staffs[i].getStaffNo() == staffNo) {
			  System.out.println(staffs[i].getName() + "("+staffs[i].getStaffNo()+") 을 삭제합니다.");
			  for(int j = 1+i; j<idx; j++) {
			    staffs[j-1] = staffs[j];
			  }
	         staffs[--idx] = null;  // 생각해보기
	         return; // 삭제 후 메소드 종료
	    } 
   } 	  System.out.println("사원번호  "+staffNo + "를 가진 사원이 없습니다.");
}
   
   public void printStaff() {
	   //사원의 이름을 입력 받아서 해당 사원 모두 조회 
	   //printStaff()를 호출하는 곳에서 모두 예외 처리
	   System.out.println("***사원 조회***");
	   System.out.print("조회할 사원이름  >> ");
	   String name = sc.next();
	   boolean exist = false; //초기화 : 조회할 사원이 없다.
	   for(int i=0; i<idx; i++) {
		 if(staffs[i].getName().equals(name)){
	       System.out.println(staffs[i]);
	       exist = true;  //조회된 사원 있음 
		}
    } if(exist == false) {  //if(!exist)  {   ==> 최근에 ! 사용 지양하고 있다.
    	System.out.println("이름이 "+ name + "인 사원은 없습니다.");
    }
  }
   
   public void printAllStaff() {
	   System.out.println("**전체 사원 목록 **");
	   for(int i=0 ;i<idx; i++) {
		  System.out.println( staffs[i]);
	   }
   }
   
   
   
   public void menu() {
	   System.out.println("***************");
	   System.out.println("***1.사원등록****");
	   System.out.println("***2.사원삭제****");
	   System.out.println("***3.사원조회****");
	   System.out.println("***4.전체조회****");
	   System.out.println("***0.관리종료****");
	   System.out.println("***************");
   }
   
   
   public void staffManage() {  
	   try{
		   while(true) {
	   
		   menu();
		   System.out.println("선택 >>> ");
		   int choice = sc.nextInt();
		   
		   switch(choice) {   
		   case 1:  addStaff();   break;
		   case 2: deleteStaff(); break;
		   case 3: printStaff();  break;
		   case 4: printAllStaff(); break;
		   case 0: System.out.println("**사원관리종료**"); return; //staffManage() 메소드를 종료하는 return;	   
		    } //switch 종료
	      } //while 종료
	 }catch (Exception e ) {
		   System.out.println("예외발생");
	   }
   
   }
   
  
   
   
   
   
   
}
