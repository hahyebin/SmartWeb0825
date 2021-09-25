package ex2_two_dimension;

import java.util.Scanner;

public class dd {

		private static void quiz1() {
	        
	        String[] names = new String[] { "피카츄","뽀로로", "브레드"};
			String[] subjects = {"국어", "영어", "수학"};
			int[][] scores = new int[names.length][subjects.length];
			
			Scanner s = new Scanner(System.in);
			
	        
	      //점수 입력 받는 코드 
		    for(int i=0; i <names.length; i++) {
		    	System.out.println(names[i]+"의 점수입력 ");
		    	for(int j=0; j<subjects.length; j++) {
		    		System.out.print(subjects[j]+ "점수 >> ");
		    	      scores[i][j] = s.nextInt();
		    	}  	
		    }//end of outer_for
			
			
		int korsum=0; int engsum=0; int mathsum=0;
			
		//     국어    영어    수학  총점   평균    코드
			System.out.print("\t");
			for(int i=0; i<subjects.length; i++) {
				System.out.print(subjects[i]+"\t");
			}  System.out.println("총점"+"\t"+"평균");
			System.out.println("---------------------------------------");
			
			
			
		// 학생이름 국어점수 영어점수 수학점수 총점  평균  코드	
		     for(int i=0; i<scores.length; i++) {
		    	 int sum = 0;                   // 학생이 바뀌면 sum은 리셋
		    	 System.out.print(names[i]+"\t");
		    	 
		    	 for(int j=0; j<scores[i].length; j++) {
		    	     System.out.print(scores[i][j]+"\t");
		    		 sum += scores[i][j];
		    		 
		    	 }  //end of inner
		    	 System.out.print(sum+"\t"+sum/scores[i].length);  
		    	 System.out.println();
		    	 
		    	 korsum += scores[i][0];
		    	 engsum += scores[i][1];
		    	 mathsum += scores[i][2];
		    	 
		     } // end of outer_for
		     System.out.println("-----------------------------------------");
		     System.out.println("총점"+"\t"+korsum +"\t"+engsum+"\t"+mathsum);
				

	  }//end of class

		
		public static void main(String[] args) {
			 quiz1();

		}

	}