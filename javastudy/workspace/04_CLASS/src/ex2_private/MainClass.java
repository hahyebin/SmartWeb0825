package ex2_private;

public class MainClass {

	public static void main(String[] args) {
	
		Member m = new Member();

		//m의 필드는 private하기 때문에 MainClass에서 볼 수 없다.
		//m.id       호출불가
		//m.password 호출불가

	}

}
