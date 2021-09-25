package ex5_public;



public class MainClass {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		System.out.println(calc.addition(7,2));
		System.out.println(calc.subtraction(7,2));
		System.out.println(calc.multiplication(7,2));
		System.out.println(calc.division(7,2));
		
		
		System.out.println(calc.power(2, 10));   // 1024(2의 10제곱)
		
		
	}

}
