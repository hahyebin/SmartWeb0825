package ex4_method;

import java.util.Scanner;

public class VendingMachine2 {

		// 잔돈까지 구현해보기 (스스)
     
     private int price;
     
     public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	String push(int myMoney) {
    	
    	
    	 if(price <= myMoney) {
    		 int change =  myMoney-price;
    		 
    		 switch(price) {
    		 case 500:{
    			 return "생수 "+change;
    			
    		 }case 1000:
    			 return "사이다"+change;
    		 case 1500:
    			  return "콜라"+change;
    		default :
    			return change+"원";
    		 } // switch end
    		 
    	 } else 
    		 return "돈이 부족합니다.";
    	 
    	 
    	
    	 
    	 
     } //push end
	

}  // class end
