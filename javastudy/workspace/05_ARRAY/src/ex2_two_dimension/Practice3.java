package ex2_two_dimension;

import java.util.Scanner;

public class Practice3 {

	
	private static void quiz1() {
		//성적 받기 입력 
		// 학생 3명의 이름은 "피카츄","뽀로로", "브레드"
		// 과목 3개 이름은 "국어", "영어", "수학"
		
		String[] names = new String[] { "피카츄","뽀로로", "브레드"};
		String[] subjects = {"국어", "영어", "수학"};
		int[][] scores = new int[names.length][subjects.length];
		
		Scanner s = new Scanner(System.in);
		
	    for(int i=0; i <names.length; i++) {
	    	System.out.println(names[i]+"의 점수입력 ");
	    	for(int j=0; j<subjects.length; j++) {
	    		System.out.print(subjects[j]+ "점수 >> ");
	    	      scores[i][j] = s.nextInt();
	    	}  	
	    }//end of outer
		
		
		
		//         국어     영어    수학  총점   평균 
		//피카츄    1       2       3
		//뽀로로    4       5       6
		//브레드    7       8       9
		// 총
		
	 
		int engsum=0; int korsum=0; int mathsum=0;
		
		// 1.      국어     영어    수학  총점   평균    생성하기 
		System.out.print("\t");
		for(int i=0; i<subjects.length; i++) {
			System.out.print(subjects[i]+"\t");
		}  System.out.println("총점"+"\t"+"평균");
		System.out.println("-----------------------------------------------");
		
		
		
		
	     for(int i=0; i<scores.length; i++) {
	    	 int sum = 0;
	    	 System.out.print(names[i]+"\t");
	    	 
	    
	    	 
	    	 for(int j=0; j<scores[i].length; j++) {
	    	     System.out.print(scores[i][j]+"\t");
	    		 sum += scores[i][j];
	    		 
	    	 }  //end of inner
	    	 System.out.print(sum+"\t"+(double)sum/scores[i].length);  
	    	 System.out.println();
	    	 
	    	 korsum += scores[i][0];
	    	 engsum += scores[i][1];
	    	 mathsum += scores[i][2];
	    	 
	     } // end of outer
	     
	     System.out.println("총점"+"\t"+korsum +"\t"+engsum+"\t"+mathsum);
			
			
		
		
		
		}//end of class

	
	public static void main(String[] args) {
		 quiz1();

	}

}
