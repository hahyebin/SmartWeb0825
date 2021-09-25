package ex14_singleton;

public class Calculator {
	
	
	//field
	private static Calculator calc;   //static 필드는 1개만 만들어진다.
	
	private int num;
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// new Calculator() 호출은 클래스 내부에서 한다.
	private Calculator() {
		num = 6;
	}
	
	//method
	public static Calculator getCalc() {
		if(calc == null) {
			calc = new Calculator();
		}
		return calc;
	}
}
