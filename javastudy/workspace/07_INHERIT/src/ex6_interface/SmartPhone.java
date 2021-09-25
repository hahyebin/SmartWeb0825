package ex6_interface;

public class SmartPhone implements Phone, Computer{

	@Override
	public void playGame() {
		System.out.println("게임하기 ");
		
	}

	@Override
	public void listenMusic() {
		System.out.println("음악듣기");
		
	}

	@Override
	public void sendCall() {
		System.out.println("전화");
		
	}

	@Override
	public void sendSMS() {
		System.out.println("메시지");
		
	}

	
}
