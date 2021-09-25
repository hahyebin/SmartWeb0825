package java2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Person {
	private String name;
}


class Game {
	List<Person> person;
	Scanner sc;
	
	Game(){
		person = new ArrayList<Person>();
		sc = new Scanner(System.in);
		System.out.print("겜블링 게임에 참여할 선수 숫자 >> ");
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			System.out.print((1+i)+"번째 선수 이름 > ");
		    String name = sc.next();
		   sc.nextLine();
		    person.add(new Person(name));
	}
}
	void game() {
		int[] number = new int[3];
			for(int i =0 ;i<person.size(); i++) {
				System.out.println(person.get(i).getName()+": <Enter>");
				
		    	 for(int j =0; j<number.length; j++) {
		    	    number[j] = (int)(Math.random()*3)+1;
		    	 }
		    	 if(number[0]==number[1]) {
		    		 if(number[1]==number[2]) {
		    			 System.out.println(Arrays.toString(number) +" "+person.get(i).getName()+" 승리!" );
		    			
		    		 }
		    	   } else System.out.println(Arrays.toString(number)+" "+person.get(i).getName()+" 아쉽군요!");
		    	
			
	   }
			
	}
}
	



 









public class ex2 {
	public static void main(String[] args) {
		Game g = new Game();
		g.game();
		

	}

}
