package ex14_singleton;

public class MainSpeaker {

	public static void main(String[] args) {
		
		// 생성자는 private 이기 때문에 에러 
		//SystemSpeaker speaker1 = new SystemSpeaker();
		
		//생성자의 getter를 통해 객체 생성하기 
		SystemSpeaker speaker1 = SystemSpeaker.getInstance();
		SystemSpeaker speaker2 = SystemSpeaker.getInstance();
		
		System.out.println(speaker1.getVolume());
		System.out.println(speaker2.getVolume());
		
		
		speaker1.setVolume(11);
		System.out.println(speaker1.getVolume());
		System.out.println(speaker2.getVolume());
		
		speaker2.setVolume(4);
		System.out.println(speaker1.getVolume());
		System.out.println(speaker2.getVolume());
		
		
		// 결국 getInstance를 통해 speaker1을 만들었고,
		// 이후 speaker2를 만들었지만 이미 있기 때문에 speaker1의 주소로 반환되어
		// speaker과 speaker2는 같은 참조를 함 
		
	}
}
