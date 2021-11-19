package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.mybatis.BoardDAO;
import dto.Board;

class BoardTestCase {

	 @BeforeEach
		 void 선행작업() {
			
			 Board board = new Board();
			 board.setbNo("10003");
			 board.setWriter("테스터");
			 board.setContent("테스트내용");
			 
		    int result = BoardDAO.getInstacne().insertBoard(board);
		    assertEquals(1, result, "등록오류");
		 }
	 
	 @AfterEach
	 	void 후처리작업() {
	
		 int result =	BoardDAO.getInstacne().deleteBoard("10003");
		 assertEquals(1, result, "삭제오류");	
	 }
	
	 
	 
	
    // 이 메소드는 JUnit 테스트 할 때 실행되는 메소드이다.
	//@Test 
	void 게시글목록가져오기_테스트() {   // 테스트 코드 메소드명은 "한글"로 해도 된다.	
		// 게시글 목록 가져와서 현재 갯수 맞는지 점검
	    // assertEquals("기대한 값", "실제 값", ["에러메시지"]);
		System.out.println("게시글목록가져오기_테스트");
		assertEquals(2, BoardDAO.getInstacne().selectBoardList().size() );
	}
	
	
	@Test 
	void  게시글가져오기_테스트(){
		// 게시글 번호 10000인 게시글 가져와서 null 유무 점검하기
		 //System.out.println("게시글가져오기_테스트");
		assertNotNull( BoardDAO.getInstacne().selectBoardBybNo("10003"));
	
	}
	

	
	
	

}
