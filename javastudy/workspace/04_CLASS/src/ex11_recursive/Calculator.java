package ex11_recursive;

public class Calculator {
	
	//팩토리얼 (factorial)
	//계승값
	//5! = 5x4x3x2x1   5! = 5x4!
	//4! = 4x3x2x1     4! = 4x3!
	//3! = 3x2x1       3! = 3x2!
	//2! = 2x1         2! = 2x1!
	//1! = 1           1! = 1x0
	//0! = 1               ==> factorial(a) = a * factorial(a-1)
	                                       // => a-1 * factorial(a-1-1)
	                                               // if. factorial(0)이면 1
	public int factorial(int n) {
	  if(n == 0) {
	      return 1;
	  }
	  return n * factorial(n-1);

	}
	
	
	
	

}
