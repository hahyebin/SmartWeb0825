package java1;

import java.util.Scanner;

public class ex04 {
	public static void main(String[] args) {
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50 ,10, 5, 1};
		Scanner sc = new Scanner(System.in);
		System.out.print("돈을 입력하시면 변환 금액을 알려드리겠습니다. >> ");
		int money = sc.nextInt();
		int num =0;
		
		for(int i =0; i<unit.length; i++) {
			 num = money/unit[i];
			if(money%unit[i]!= 0) {
		     System.out.println(unit[i]+"의 지폐 수 : " + num); 
          } else if (money%unit[i] == 0) {
			 System.out.println(unit[i]+"의 지폐 수 : " + num);
          } money = money%unit[i];
		}
 }
}