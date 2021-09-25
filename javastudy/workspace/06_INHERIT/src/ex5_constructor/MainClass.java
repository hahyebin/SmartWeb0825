package ex5_constructor;

public class MainClass {

	public static void main(String[] args) {
		
		
		EV ev = new EV("kona","LG");
		
		
		System.out.println(ev.getModel());          //Car 클래스의 메서드
		System.out.println(ev.getBatteryMaker());   //EV 클래스의 메서드
		


	}

}
