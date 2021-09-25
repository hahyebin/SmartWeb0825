package ex12_constructor;

public class Member {
	
	// constructor 
	// 생성자
	// 1. 객체를 생성할 때 호출되는 메소드
	// 2. 반환 타입이 없는 메소드
	// 3. 메소드이름이 클래스이름과 같아야한다.
	
	private String id;
	private String password;
	
	public Member() {
		
	}
	
	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}


	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	 
	
}
