package java2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Player{
	private String name;
    Scanner sc = new Scanner(System.in);
	
	Player(String name){
		this.name = name;
	}
	
	public int turn() {
	
		String key = sc.nextLine();
		Calendar c = Calendar.getInstance();
		int start = c.get(Calendar.SECOND);
		System.out.println("현재 초 시간 : " + start);
		System.out.print("10초가 된 것 같으면 <Enter>");
         key = sc.nextLine();
         c = Calendar.getInstance();
         int end= c.get(Calendar.SECOND);
         System.out.println("현재 초 시간 : " + end);
         if(end < start)
        	 end += 60;
         
	
	    return end - start;
	
	}
}
public class ex4 {

	public static void main(String[] args) {
	
		Player[] p = new Player[2];
		p[0] = new Player("tom");
		p[1] = new Player("alice");
		
	         System.out.print(p[0].getName()+"시작 <Enter>");
			int tomtime = p[0].turn();
			  System.out.print(p[1].getName()+"시작 <Enter>");
			int alicetime = p[1].turn();
			System.out.print(p[0].getName() + "의 결과 : "+ tomtime+", ");
			System.out.print(p[1].getName() + "의 결과 : "+ alicetime + "  ");
			
			if(tomtime>alicetime) {
				System.out.println(p[1].getName() + " 승리" );
			} else if(tomtime<alicetime)
				System.out.println(p[0].getName() + " 승리" );
			
      }
   }

