package ex2_two_dimension;

import java.util.Scanner;

public class Practice {

	
	private static void quiz1() {
		//성적 받기 입력 
		// 학생 3명의 이름은 "피카츄","뽀로로", "브레드"
		// 과목 3개 이름은 "국어", "영어", "수학"
		
		String[] names = new String[] { "피카츄","뽀로로", "브레드"};
		String[] subjects = {"국어", "영어", "수학"};
		int[][] scores = new int[names.length][subjects.length];
		
		Scanner s = new Scanner(System.in);
		
		
		for(int i=0; i<scores.length; i++) {    //변수 i는 학생번호를 의미함.
			 System.out.println(names[i]+"의 점수 입력 ");
			for(int j=0; j<scores[i].length; j++) {     	
	         	System.out.println(subjects[j] + " 점수 >>> ");
				scores[i][j] = s.nextInt();     	
			}
		}
		
		//         국어     영어    수학 
		//피카츄    1       2       3
		//뽀로로    4       5       6
		//브레드    7       8       9
		
		//과목라인 출
	    System.out.print("\t");
		for(int i =0; i<subjects.length; i++) {
			System.out.print(subjects[i] + "\t");
		}
		System.out.println();
		
	
		for(int i =0; i<scores.length; i++) {
			System.out.print(names[i]+"\t");
             for(int j=0; j<scores[i].length; j++) {
            	 System.out.print(scores[i][j]+"\t");
 
             }System.out.println();
		}
		

		
	}  
	
	
	
	public static void main(String[] args) {
		 quiz1();

	}

}
