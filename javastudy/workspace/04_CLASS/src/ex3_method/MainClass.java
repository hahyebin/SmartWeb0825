package ex3_method;

public class MainClass {

	public static void main(String[] args) {
		Person p = new Person();
		
	   String result1 = p.bibigi("물", "밀가루");
	   String result2 = p.bibigi("물", "쌀가루");
	   String result3 = p.bibigi("술", "우유");
	   
	   System.out.println(result1);               //밀반죽
	   System.out.println(result2);               //쌀반죽 
	   System.out.println(result3);               //모름
	   System.out.println(p.bibigi("물", "우유"));     //모름
	   System.out.println(p.bibigi("물", "밀가루"));   //밀반죽
	}

}
