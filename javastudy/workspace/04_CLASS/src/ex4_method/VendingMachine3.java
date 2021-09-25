package ex4_method;

import java.util.Scanner;

public class VendingMachine3 {
	public static void main(String[] args) {

	    int water = 500;
	    int cider = 1000;
	    int coke  = 1500;
	    int change=0;
        	 
		  System.out.print("음료수를 선택해"
		  		+ "세요(1.생수:500원, 2.사이다:1000원, 3.콜라:1500) 4.반환 >> ");
		  
		  Scanner scan = new Scanner(System.in);
		  int choice = scan.nextInt();
		  System.out.print("돈을 넣어주세요 >> ");
		  int myMoney = scan.nextInt();
		
		 

	 while( true) {
		
	  switch(choice) {
		 case 1: {
			 change = myMoney-water;
	         if(myMoney>=water)  {	 
	             System.out.println("생수를 받아가세요 "); 
	            	 if(change>0) 
	            	  System.out.println("거스름 : "+change);
	           }
	          else  
	  		      System.out.println("돈이 부족합니다. "+myMoney+"원을 가져가세요.");     
	  	     return;
		 }
	  	     
		 case 2:{ 
			 change = myMoney-cider;
	    		  if(myMoney>=cider) {
		             System.out.println("사이다를 받아가세요 ");
	    		       if(change>0) 
	            	       System.out.println("거스름 : "+change);
	    		  }  else 
	    			 System.out.println("돈이 부족합니다. "+myMoney+"원을 가져가세요.");  	
	    	     return;	   
	    }
		   
		 case 3: {
			  change = myMoney-coke;
			 if(myMoney>=coke) {
		        System.out.println("콜라를 받아가세요 ");
			   if(change>0) 
      	       System.out.println("거스름 : "+change);
			 }
			 else 
				 System.out.println("돈이 부족합니다. "+myMoney+"원을 가져가세요.");  
			 return;
		 }
		 case 4: {
	    	   System.out.println("반환을 입력하였습니다.");
	    	   change = myMoney;
	    	   System.out.println(change+"를 가져가세요.");
	    	   return;
		 }
	    default :
	    	System.out.println("잘못입력 "+myMoney+"를 가져가세요.");
	    	
	       
	    return;
                          
	     } //switch	     
	 }   
   }
}

   
	      
	      



