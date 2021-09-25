package ex13_static;

public class MainClass {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		//객체를 이용한  static method 호출은 권장하지 않음
		System.out.println(calc.addition(1, 2));
	
		
		Calculator calc2 = new Calculator();
		System.out.println(calc2.addition(1, 2));
		
		//static way
		System.out.println( Calculator.addition(1,3));
		
	}

}
