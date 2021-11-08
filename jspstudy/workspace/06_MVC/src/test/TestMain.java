package test;

public class TestMain {

	 public static void main(String[] args) {
		//인터페이스(TestInterface)를 구현한 클래스 (TestA와 TestB)는 
		// 인터페이스 타입으로 생성할 수 있다.
		
		TestInterface obj = null;
		
		if( Math.random() < 0.5) // 50%확률 
			obj = new TestA();
		 else 
			obj = new TestB();
		
		
		obj.doSome();
		
		
	}

}
