package ex12_constructor;

public class MainClass {

	public static void main(String[] args) {
		
		//필요한 값만 호출하는게 좋기 때문에 
		//디폴트 생성자를 이용해서 getter, setter를 이용하는게 좋다
		Member m = new Member();
		m.setId("admin");
		m.setPassword("1234");
		System.out.println(m.getId());
		System.out.println(m.getPassword());

		//호출과 초기화 동시에
		Member m2 = new Member("hyebin", "1234");
		System.out.println(m2.getId());
		System.out.println(m2.getPassword());
	}
}
