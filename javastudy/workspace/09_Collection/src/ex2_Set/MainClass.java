package ex2_Set;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass {
	
	public static void method1() {
		
		//Set 
		//1. 저장 순서가 없다.(인덱스가 없다)
		//2. 중복 저장이 불가능하다.
		
		//생성    -->  순서x, 중복x 
		Set<String> subjects = new HashSet<String>();
		
	   //데이터 추가 
		subjects.add("자바");
		subjects.add("자바");
		subjects.add("JSP");
		subjects.add("파이썬");
		subjects.add("스프링");
		
		//확인 
		System.out.println(subjects);
		
		
		//데이터 제거 
		subjects.remove("JSP");
		//확인 
		System.out.println(subjects);
		
	
	}
	
	public static void method2() {
		
		
		//Set의 초기화 : List -> Set 생성자에 넣어 줌 
	     Set<String> hobbies = new HashSet<String>(Arrays.asList("수영","조깅","푸시업"));
		
		//일반 for문 -> set은 인덱스가 없어서 불가능!
		
		//향상 for문 사용가능(인덱스사용안함)
		for(String hobby : hobbies) {
			System.out.println(hobby);
		}
	}
		
	public static void method3() {
	   //lotto 번호 6개를 HashSet에 저장 
		
		// <>
		// 제네릭 처리 : 오직 클래스만 타입으로 사용할 수 있다.
		//        int, long, double 등은 사용할 수 없다.
		
	    Set<Integer> lotto = new HashSet<Integer>();
	    
	    while(true) {  //lotto.add는 한번만!
	    	lotto.add((int)(Math.random()*45)+1);
	    	if(lotto.size() ==6) {
	    		break;
	    	}
	    }
	    //위의코드보다 쉬운 버전 while의 조건을 처음부터 달아줌 
	    while (lotto.size()<6) {
	    	lotto.add((int)(Math.random()*45)+1);
	    }
	    System.out.println(lotto);
	    
	    //Set -> List
	    List<Integer> list = new ArrayList<Integer>(lotto);
	    Collections.sort(list);   //오름차순 정렬 
	    System.out.println(list);
	    
	    Collections.sort(list,  Collections.reverseOrder());  // 내림차순 정렬 
	    System.out.println(list);
	    

		
		System.out.println("-------------");
		// 내가 한거   --> add() 6번은 안됨 ?
		Set<Integer> lotto1 = new HashSet<>();
		
		for(int i=0; lotto1.size()<6; i++) {
		int	num = (int)(Math.random()*45)+1;
			lotto1.add(num);
		}
		
		System.out.println(lotto1);
		
	}
	
//	어제 set 관련해서 로또 코드 만들때 add()를 여섯번 돌리면 안된다고 하셨는데,
//	Set<Integer> lotto1 = new HashSet<>();
//	
//	for(int i=0; lotto1.size()<6; i++) {
//	int	num = (int)(Math.random()*45)+1;
//		lotto1.add(num);
//	}
//	
//	System.out.println(lotto1);
//	 
//	이런식의 형태가 안된다는게 맞을까요..?
	
	
	
	
public static void main(String[] args) {
	method3();
   }
}
