package ex5_instance_array;

 public class Producer {

	private String name;

	public Producer(String name) {
		super();
		this.name = name;
	}
	
	
	//어떤 가수에게 어떤 노래를 주는 produce 메서드 생성
	//객체간의 연결을 확인하기 위해 Producer 클래스를 생성함 
	
	public void produce(Singer singer, Song song) {
		singer.addsong(song);
	}
	
	

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
} // end of class
