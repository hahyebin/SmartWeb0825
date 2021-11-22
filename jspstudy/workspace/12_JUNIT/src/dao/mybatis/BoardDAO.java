package dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Board;
import mybatis.config.DBService;

public class BoardDAO {
	private SqlSessionFactory factory;
	
	private static BoardDAO instance = new BoardDAO();
	public  BoardDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static BoardDAO getInstacne() {
		return instance;
	}
	
	// 1. 게시판 리스트
	public List<Board> selectBoardList(){
		SqlSession ss = factory.openSession();
		List<Board> list = ss.selectList("dao.mybatis.board.selectBoardList");
		ss.close();
		return list;
	}
	
	// 2. 게시글 등록
	public int insertBoard(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.mybatis.board.insertBoard", board);
		if( result > 0 ) ss.commit();
		ss.close();
		return result;
	}
	
	// 3. 게시글 삭제
	public int deleteBoard(String bNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.mybatis.board.deleteBoard", bNo);
		if( result > 0 ) ss.commit();
		ss.close();
		return result;
	}
	
	// 4. 게시글 확인하기 --> junit 확인용
	public Board selectBoardBybNo(String bNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("dao.mybatis.board.selectBoardBybNo", bNo);
		ss.close();
		return board;
	}
	
} // class
