package ex14_singleton;

public class Calculator2 {
	
	private static Calculator2 calc;
	
	private Calculator2() {}
	
    public static Calculator2 getCalc() {
    	if(calc == null) {
    		calc = new Calculator2();
    	} return calc;
    }
}
