package java1;

import java.util.Scanner;

public class ex03 {

	public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
		System.out.println(" ===커피 메뉴=== ");
		System.out.println("메뉴를 선택해주세요. 가격을 알려드릴게요");
		System.out.print("1. 에스프레소, 2.카푸치노, 3. 카페라떼, 4. 아메리카노 >> ");
		int choice = sc.nextInt();
	 while(true) {
		  switch(choice) {
		  case 1: System.out.println(choice + ".에스프레소는 3,500원입니다."); break;
		  case 2: System.out.println(choice + ".카푸치노는 3,500원입니다."); break;
		  case 3: System.out.println(choice + ".카페라떼는 3,500원입니다."); break;
		  case 4: System.out.println(choice + ".아메리카노는 2,000원입니다."); break;
		  default : System.out.println("선택하신 메뉴는 없는 메뉴입니다."); return;
		  }
		  System.out.println("메뉴 알림 종료");
		  return;
	 }
	   
	}

}
