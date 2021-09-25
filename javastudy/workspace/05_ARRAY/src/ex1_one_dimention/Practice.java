package ex1_one_dimention;

import java.util.Scanner;

public class Practice {
	
	private static void quiz1() {
		
		//성적 관리하기
		// 학생 3명의 이름은 "피카츄","뽀로로", "브레드"
		// 실행 ㅇㅖ)
		// 피카츄의 점수 입력 >> 12
		// 뽀로로의 점수 입력 >> 11
		// 브레드의 점수 입력 >> 10
		// 평균 : 11.0점
		// 1등  : 피카츄
		// 3등  : 브레드
		
		
		
		String[] names = new String[] { "피카츄","뽀로로", "브레드"};
		int[] scores = new int[names.length];
		
		Scanner s = new Scanner(System.in);
		
		
		for(int i=0; i<names.length; i++) {
	     	System.out.print(names[i] +"의 점수 입력 >> ");
	     	scores[i] = s.nextInt();     	
		}
		
		int sum = scores[0];
		int max = scores[0];   	int top = 0;
		int min = scores[0];    int last = 0;
	
		for(int i= 1; i<scores.length; i++ ) {
			sum += scores[i];
			if(max < scores[i]) {
			   max = scores[i];
			   top = i;
			}
			
			if(min>scores[i]) {
				min = scores[i];
				last = i;
			}
		}
		System.out.println("평균 : "+ (double)sum/scores.length + "점");
		System.out.println("1등  : "+names[top]);
		System.out.println(scores.length+"등  : "+names[last]);
	
		
		
		s.close();		
	}
	
	
	private static void quiz2() {
		
		//윷 놀이
		//"도", 1칸 이동한다.
		//"개", 2칸 이동한다.
		//"걸", 3칸 이동한다.
		//"윷", "걸", 이동한다.
		// 빽도 없음 
		
		            //인덱스를 윷의 이동횟수와 일치하게 함        
		String[] yutnori = {"", "도","개","걸","윷", "모"};
		
	int total = 0;   	
	while(true) {
	
		//이동 횟수는 랜덤 생성한다.
	   int move = (int)(Math.random()*5)+1; // 1~ 5개의 숫자
	   System.out.print(yutnori[move]);
	   
	   //이동횟수 누적
	   total += move;
		
	   if(move <= 3) {
		   System.out.println(", "+total+"칸 이동한다.");
		   break;
	   } else {
		   System.out.print(", ");
	   }
	}
}
	
	
	public static void main(String[] args) {
		 quiz2() ;
		
		
	}
}

























