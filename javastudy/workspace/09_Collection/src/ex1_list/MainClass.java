package ex1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void method1() {
		//생성 
		List<String> list = new ArrayList<String>();
		
		// 추가 
		list.add("자바");  //마지막 요소로 추가 
		list.add("데이터베이스");
		list.add("자바");
		list.add(0,"프론트");   // 인덱스 0에 추가  
		
		//확인 
	    System.out.println(list);
	    
	    
		//제거 
		list.remove(0);  //인덱스 0 제거 
		list.remove("자바"); //값으로 제거 //앞에서부터 제거 (인덱스 1번 자바가 삭제)
		
		list.get(0);
		list.get(1);
	
		
		
		//확인 
		System.out.println(list);
	}
	
	public static void method2() {
		// 초기화 
		List<String> foods = Arrays.asList("사과","김치찌개","삼겹살"); 
		
		// 길이
		System.out.println(foods.size());
		
		//인덱스를 활용해 개별요소 출력 
		System.out.println(foods.get(0)); //사과 
		System.out.println(foods.get(1)); //김치찌개
		System.out.println(foods.get(2)); //삼겹살
		
		// 수정 
		foods.set(0, "김밥"); //인덱스 0 수정 
		System.out.println(foods.get(0));
		
		
	}
	
	public static void method3() {
		List<String> list = Arrays.asList("짱구","뽀로로","띠띠뽀");
		
	    //일반 for문  (size()메서드를 여러번 호출하기 때문에 메소드를 여러번 반복 실행함으로써 성능에 안 좋을수 있음 )
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		//개선된 일반 for문(size() 메소드를 한 번만 호출 )
		for(int i=0, size = list.size(); i<size; i++ ) {
			System.out.println(list.get(i));
		}
		
		//향상 for문 
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		 method2();
	}
}
