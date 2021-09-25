package ex14_singleton;


// 싱글톤 이해 위한 스스로 학습 

public class SystemSpeaker {

	
	// 아무나 접근을 하지 못하지만 어디서든 호출이 가능해야하므로 static 
	// SystemSpeaker타입의 instance 인스턴스 
	private static SystemSpeaker instance;
	
	//스피커 볼륨값 생성(외부에서 접근못하는)
    private int volume;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}


	//접근 막는 생성자생성 
	private SystemSpeaker() {
     	volume =5;    // Speaker의 볼륨 기본값은 5
	}
	
	
	//instance getter 를 통해 갖고오기 
	public static SystemSpeaker getInstance() {
		//만약 인스턴스가 null이면 instance 생성 아니면 기존 instacne 반환 
		if(instance == null)
			instance = new SystemSpeaker();
		return instance;
		
		
	}
	
	
	
	
	
	
}
