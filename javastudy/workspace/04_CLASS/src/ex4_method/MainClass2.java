package ex4_method;

import java.util.Scanner;

public class MainClass2 {

	public static void main(String[] args) {
	     
	     VendingMachine2 v = new VendingMachine2();

		  System.out.println("음료수 값을 넣어주세요(생수:500원, 사이다:1000원, 콜라:1500) >> ");
		     Scanner s = new Scanner(System.in);
		     int myMoney = s.nextInt();
	         
		     
		     v.setPrice(500);
		    
		     System.out.println( v.push(myMoney));
	}

}
