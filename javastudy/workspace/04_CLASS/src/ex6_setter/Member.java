package ex6_setter;

public class Member {
	
	//field
	private String id;
	private String password;
	
	//setter
	//field에 값을 전달하는 메소드
	//setter를 이용해서 field 값을 저장
	//반환값이 void : 반환타입이 없다.
	//메소드 이름 정의 : set + 변수명
	public void setId(String str){
		id = str;
		
	}
	public void setPassword(String str) {
		password = str;
		
	}

}
