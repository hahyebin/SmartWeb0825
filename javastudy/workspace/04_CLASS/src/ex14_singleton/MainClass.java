package ex14_singleton;

public class MainClass {

	public static void main(String[] args) {
		
		
		//이걸 막고 싶다.(constructor를 private하게 바꿈)
		//Calculator calc = new Calculator();

		//getCalc() 메소드를 호출
		//객체를 이용한 호출 : 불가능. 객체 못 만들게 private constructor로 처리했으므로
        //클래스를 이용한 호출 : 가능하다.
		
		Calculator calc1 = Calculator.getCalc();
		Calculator calc2 = Calculator.getCalc();
		Calculator calc3 = Calculator.getCalc();
		Calculator calc4 = Calculator.getCalc();
		
		
		System.out.println(calc1.getNum());
		System.out.println(calc2.getNum());
		System.out.println(calc3.getNum());
		System.out.println(calc4.getNum());
		
	    calc1.setNum(10);
	    System.out.println(calc1.getNum());
		System.out.println(calc2.getNum());
		System.out.println(calc3.getNum());
		System.out.println(calc4.getNum());
		
		
	}

}
