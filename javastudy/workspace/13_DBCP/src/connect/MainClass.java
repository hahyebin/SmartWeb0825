package connect;

public class MainClass {

	public static void main(String[] args) {
		
		// static은 클래스명.메소드명 으로 호출하기 
		//DBCPConnection 클래스의 getInstance() 메소드 호출하기
		
		
		// 호출방법1 : 객체로 호출하기   (X) -> 외부에서는 DBCPConnection 객체를 생성할 수 없으므로(private 생성자)
		// 호출방법2 : 클래스로 호출하기 (O) -> 클래스 메소드(static)
		DBCPConnection사용아함 con = DBCPConnection사용아함.getInstance();
		DBCPConnection사용아함 con1 = DBCPConnection사용아함.getInstance();
		System.out.println(con==con1);
		System.out.println(con);
		System.out.println(con1);
	}

}
