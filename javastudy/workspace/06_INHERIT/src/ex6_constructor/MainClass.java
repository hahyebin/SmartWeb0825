package ex6_constructor;

public class MainClass {

	public static void main(String[] args) {
		
		Square square = new Square(5.2);
		
		System.out.println(square.getWidth());
		System.out.println(square.getHeight());
		
		
		
		//혼자 구현한 코드
		System.out.println(square.area());
		

	}

}
