package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Board;
import dto.Reply;
import mybatis.config.DBService;

public class BoardDao {
	private SqlSessionFactory factory;
	
	/* singleton */
	private static BoardDao instance;
	private BoardDao() {
		factory = DBService.getInstance().getFactory();          // DBService 싱글톤 패턴의 객체를 위해 getInstance() 호출을 통해 객체 생성하고, getFactory를 호출해서 factory를 얻어온다.
	}
	public static BoardDao getInstance() {
		if(instance == null ) {
			instance = new BoardDao();
		} return instance;
	}
	

	// 1. 이미지 삽입 
	public int insertBoard(Board board) {
		SqlSession ss= factory.openSession(false);
		int result = ss.insert("dao.board.insertBoard", board);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 2. 전체이미지
	public List<Board> selectBoardList(){
		SqlSession ss = factory.openSession();
		List<Board> list = ss.selectList("dao.board.selectBoardList");
		ss.close();
		return list;
	}
	
	// 3. 상세보기 
	public Board selectBoardView(Long bNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("dao.board.selectBoardView", bNo);
		ss.close();
		return board;
	}
	
	
	
}// end of class
