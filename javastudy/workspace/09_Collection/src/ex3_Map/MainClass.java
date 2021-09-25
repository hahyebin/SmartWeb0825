package ex3_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainClass {
    //bean : 데이터 여러개 저정해서 보낼때
	//Map : bean 대용(데이터보내기 & 데이터받기)
	
	
	//HashMap
	//1. Map 인터페이스를 구현한 클래스이다.     //키와 값을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스르 구현하는데 사
	//2. 데이터가 쌍(pair)으로 구성된다.
	//   키(key)-값(value)  => 변수-값 
	//3. 키(key)
	//   값(value)을 꺼낼 때 사용하고, 중복된 키(key)는 존재할 수 없다.
	//4. 값(value)
	//   실제 데이터를 의미하고, 중복된 값(value)은 가능하다.
	//5. 순서유지 안한다. key는 중복이 안되기 때문에..
	
	public static void method1() {
		//생성 
		Map<String, Integer> sungjuk = new HashMap<String, Integer>();
		
		//데이터 저장 
		sungjuk.put("국어", 80);
		sungjuk.put("영어", 100);
		sungjuk.put("수학", 70);
		
		//데이터 확인 
		System.out.println(sungjuk);
		
		//데이터 수정 (동일한 키(key)를 사용하면 수정)
		sungjuk.put("국어", 90);
		//확인
		System.out.println(sungjuk);
		
		//데이터 삭제 
		sungjuk.remove("수학");
		//확인
	    System.out.println(sungjuk);
	}
	
	public static void method2() {
		
		 Map<String, Object> staff = new HashMap<String, Object>();
		 
		 staff.put("staffNo", 1000);
		 staff.put("name", "천송이 ");
		 staff.put("dept", "전략");
		 
		 //개별요소 
		 System.out.println("사원 번호 : " + staff.get("staffNo"));
		 System.out.println("사원명 : " + staff.get("name"));
		 System.out.println("부서명 : " + staff.get("dept"));
	 }
	 
	public static void method3() {
        Map<String, Object> staff = new HashMap<String, Object>();
		 
		 staff.put("사원번호", 1000);
		 staff.put("사원명", "천송이 ");
		 staff.put("부서명", "전략");
		 
		 //Map과 반복문1
		 // 키(key)만 뺴서 개별 요소 접근하기  -> 키를 알아내서 값을 얻기 
		 Set<String> keys = staff.keySet();
		 for(String key : keys) {
			 System.out.println(key + ": " + staff.get(key));
		 }
		 
		 
		 //Map과 반복문2 
		 // 키(key)-값(value) 조합을 빼서 접근하기 
		 // Entry: 키(key)-값(value) 합쳐서 부르는 용어  
		 for( Map.Entry<String, Object> entry : staff.entrySet()) {
			 System.out.println(entry.getKey()+ ": "+entry.getValue());
		 }
		 
		 
		 
		 
	}
	 
	public static void main(String[] args) {
	   method3();    
	

	}

}
