package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import mybatis.config.MybatisSetting;

public class BoardDAO {
	// SqlSessionFactory 을 통해 삽입 수정 삭제 조회 가능 
	// dbcp는 mybatis.jar 처리 
	private SqlSessionFactory factory;
	
	private static  BoardDAO  instance;

	private  BoardDAO () {
		factory = MybatisSetting.getInstance().getFactory();
	}
	
	public static BoardDAO getInstance() {
		if( instance == null ) {
			instance = new BoardDAO();
		} 
		return instance;
	}
	
	// 1. 전체 사원 조회
	public List<BoardDTO> selectList(){
		
		SqlSession ss = factory.openSession();   // 조회는 인자없음 
		
		List<BoardDTO> boards = ss.selectList("mybatis.mapper.sqlmap.selectList");
		
		ss.close();
		
		return boards;
	}
	
	// 게시글 총 수 세기 
	public int getCount() {
		
		SqlSession ss = factory.openSession(); 
		
		int count = ss.selectOne("mybatis.mapper.sqlmap.getCount");
		
		if (count > 0) {
			ss.close();
		}
		return count;
	}
	
	// 2. 사원 삽입-게시판리스트로감 
	public int insert(BoardDTO boardDto) {
		SqlSession ss = factory.openSession(false);   
		int result = ss.insert("mybatis.mapper.sqlmap.insert", boardDto);
		if( result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	// 2-1. 사원삽입 - 게시판 컨텐츠 저장용
	public int insert2(BoardDTO boardDto) {
		SqlSession ss = factory.openSession(false);   
		int result = ss.insert("mybatis.mapper.sqlmap.insert2", boardDto);
		if( result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	// 3. 사원 정보 반환   
	public BoardDTO selectBoardByNum(Long idx){
		
		SqlSession ss = factory.openSession();    // select 처리는 openSession() : 인수없음 (insert,delete, update 시에는 존재함)
		BoardDTO board = ss.selectOne("mybatis.mapper.sqlmap.selectBoardByNum", idx);
		ss.close();
		return board;
	}
	
	
	
	// 4. 사원 수정 
	public int update(BoardDTO boardDto) {
		SqlSession ss = factory.openSession(false); 
		int result = ss.insert("mybatis.mapper.sqlmap.update", boardDto);
		if( result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	// 5. 사원 삭제
	public int delete(Long idx) {
		SqlSession ss = factory.openSession(false); 
		int result = ss.insert("mybatis.mapper.sqlmap.delete", idx);
		if( result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
 } //end of class





