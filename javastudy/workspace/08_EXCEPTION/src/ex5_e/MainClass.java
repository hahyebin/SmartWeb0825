package ex5_e;


public class MainClass {

	
	//예외처리catch - > 알면 아는대로 모르면 Exception
	// 예외추적하기 e.printStackTrace();
	
	 public static void method1() {
    	 try {
    		 String strAge = "44.8";
    		 int age = Integer.parseInt(strAge);
    		 System.out.println("나이는" + age +"살입니다.");
    	 } catch(NumberFormatException e) {   //예외객체 e
    		 System.out.println(e.getMessage());  //메시지 : 예외가 발생한 이유   getMessage()
    		 e.printStackTrace();  //예외 추적하기 
    	 }
     }

	 public static void method2() {
		 try {
		 throw new RuntimeException("내가 발생시킨 예외이다. 이유 없이");
		 } catch(Exception e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();                //예외발생하면 수정해야하니까 e.printStackTrace();를 많이 활용
		 }
	 }

	 public static void method3() {

		 
		 //자바가 예외처리하는경우
		 try {
			 throw new RuntimeException("예외발생 ");
		 } catch(Exception e) {
			 throw new RuntimeException("다시 예외 발생", e);
		 }
		 
		 
	 }


	 public static void main(String[] args) {
                 method3();
    
	}

}
//1. 드라이브   d:  ->    2.cd D:\ 롬복위치  ->

//3.java.exe -jar lombok.jar    파일 추가해서 롬복 설치하기 
//==java -jar lombok.jar
//롬복 고추있는 거 실행되면 이클립스 파일위치!선택
//마지막으로 이클립스에서 path 설정을 add 를 통해 이클립스파일위치!에 있는 롬복 선택!