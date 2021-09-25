package java1;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 >>");
		int score = sc.nextInt();
		System.out.print("학년 >> ");
		 int grade= sc.nextInt();	 
		 if(score>=60) {
			System.out.println("합격입니다. ");
		  if(grade ==4) {
			  if(score<70) {
				  System.out.println("불합격입니다.");
			  }
		  }
	} else
		System.out.println("불합격입니다. ");
  }
}


