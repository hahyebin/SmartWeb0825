package java2;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Phone{
	private String name;
	private String tel;

}

class PhoneBook{
	Scanner sc = new Scanner(System.in);
	List<Phone> phone;
	
	PhoneBook(){
		phone = new ArrayList<Phone>();
	}

	void addphonebook() {
		System.out.print("저장 인원 수 >> ");
		int num = sc.nextInt();
		  for(int i=0; i<num; i++) {
	    System.out.print("이름과 전화번호 >> ");
		String name = sc.next();
		//sc.nextLine();
		//System.out.print("과 전화번호 > ");
		String tel = sc.next();
		phone.add(new Phone(name, tel));
		}
		  System.out.println("저장되었습니다. ");
	}
	
	
	
	void search() {
//		try {
//		System.out.print("검색할 이름 > ");
//		String name = sc.next();
//	     sc.nextLine();
//		for(int i =0; i<phone.size(); i++) {
//			if(phone.get(i).getName() == name) {
//				 System.out.println(phone.get(i).getName()+"의 번호는 "+phone.get(i).getTel()+" 입니다.");
//				
//			} else if("그만" == name) {
//				System.out.println("프로그램 종료 ");
//			} 
//			System.out.println(name +"이 없습니다. ");
//		  
//		}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		System.out.print("검색할 이름 > ");
		String name = sc.next();
	     sc.nextLine();
	     for(Phone phones : phone) {
	    	 if(phones.getName().equals(name)) {
	    		 System.out.println(phones.getName()+"의 번호는 "+ phones.getTel()+"입니다.");
	    		 break;
//	    	 } else if(name.equals("그만")) {
//	    		 System.out.println("프로그램 종료 ");
//	    		 return; 
	         } else {
	    	     System.out.println(name + "이 없습니다. ");
	    	     break;
	    	   }  
	     }
	}
	
	void manage() {
		while(true) {
			System.out.println("====phonebook에는 저장(1),검색(2), 종료(3) 기능이 있습니다. ====");
			System.out.print("===번호를 입력해주세요. ");
			int choice = sc.nextInt();
		switch(choice) {
		case 1: addphonebook(); break;
		case 2: search(); break;
		case 3: System.out.println("프로그램 종료"); return;
		default : System.out.println("잘못입력했습니다."); break;
		}
	} 
  }	
}
public class ex1 {
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook();
		pb.manage();
	}

}
