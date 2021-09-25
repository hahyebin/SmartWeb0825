package ex8_Object;

public class MainClass {
	public static void main(String[] args) {
		
	
	
	Object obj = null;
	
	obj = new Member("admin");
	
	((Member)obj).getId();
	((Member)obj).getPwd();
	
	Member member = (Member)obj;
    member.setId("adminmin");
    member.setPwd("1234");
    System.out.println(member.getId());
    System.out.println(member.getPwd());
    
    obj = new Board("공지사항","내일도 수업");
    
   Board board = (Board)obj;
   System.out.println("제목 : "+ board.getTitle());
   System.out.println("내용 : "+ board.getContent());
    

}
}
