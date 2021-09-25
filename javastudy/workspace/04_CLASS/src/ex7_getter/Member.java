package ex7_getter;

public class Member {
	
	//field
	private String id;
	private String password;
	private boolean korean;
	
	
	//getter
	//field 값을 반환하는 메소드
	//getter를 통해서 field값을 확인
	//메소드 이름 정의 : get + 변수명
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public boolean isKorean() {      //boolean 타입의 getter는 is로 시작한다.
		return korean;
	}

	
	

}
