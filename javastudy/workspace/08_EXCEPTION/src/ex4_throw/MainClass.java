package ex4_throw;

import java.util.Scanner;

public class MainClass {
    
	private static Scanner sc = new Scanner(System.in);
     
	public static void method1() {
		try {
		   System.out.println("점수입력(0~100) >> ");
		   int score = sc.nextInt();   //static은 static만호출가능 
		   if(score <0 || score>100) {  //예외의 직접 처리
			   throw new RuntimeException("점수의 범위를 벗어나 예외발생 ");    // 런타임예외로 던짐 
		    }  
	  	   if(score>=60) {
		 	System.out.println("합격입니다.");
		    } else {
		     System.out.println("불합격입니다.");
		   }
		}catch(Exception e) {                  //예외의 최고조상인 Exception이 받음 
			System.out.println("예외가 발생했습니다.");
		}
		
	}
	
	
	public static void method2() throws NumberFormatException, NullPointerException {   //던지는 예외를 throws명시
		if(Math.random()<0.5) {
		    throw new NumberFormatException();
	  } else {
			throw new NullPointerException();
		}
	}

	public static void main(String[] args) {
	//	method1();
		try {
			method1();
			
		} catch (Exception e) {
			System.out.println("예외 발생");
		}

	}

}
