package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {
	private static  BoardDAO  boardDAO;

	private  BoardDAO () {
	}
	
	public static BoardDAO getInstance() {
		if( boardDAO == null ) {
			boardDAO = new BoardDAO();
		} 
		return boardDAO;
	}

	/* context.xml 내용으로 DataSource 객체 생성->DBCP처리 */
	private static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");   
			// WAS가 톰캣인 경우 	java:comp/env 
			// <Resource name>	 	jdbc/oracle11g  -> jndi방식 
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	/* field */
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	/* method */
	
	// 1. 접속 해제 
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {     //  객체가 static으로 자리잡았기 때문에 객체 생성이되면  내부 메소드 사용이 가능하다.
		try {
			if( con != null ) { con.close(); }
			if( ps != null ) { ps.close(); }
			if( rs != null ) { rs.close(); }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 2. 삽입 
	public int insert(BoardDTO boardDTO) {    // board DB에  data넣어야 하기 때문에 매개변수를 객체로 받기 
		int result =0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO board VALUES(board_seq.nextval, ?, ? ,? , SYSDATE)"; 
			ps = con.prepareStatement(sql);
			ps.setString(1, boardDTO.getTitle());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
		
	}
	
	
	// 3. 삭제
	public int delete(Long idx) {          // idx 받아 찾아서 삭제 
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM board WHERE idx=?";
			ps =con.prepareStatement(sql);
			ps.setLong(1, idx);
			result = ps.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		
		return result;
	}
	
	
	// 4. 수정 
	public int update(BoardDTO boardDTO) {         // 객체에 있는 필드 수정이므로 객체로 받기 
		int result = 0;
		try {
			con = dataSource.getConnection();
		    sql = "UPDATE board SET title=?, content=? WHERE idx = ?";
		    ps = con.prepareStatement(sql);
		    ps.setString(1, boardDTO.getTitle());
		    ps.setString(2, boardDTO.getContent());
		    ps.setLong(3, boardDTO.getIdx());
		    result = ps.executeUpdate();
		} catch ( Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}

		
		return result;
	}

	
	
	// 5. 조회
	public BoardDTO selectDTO(Long idx) {
		BoardDTO boardDTO =null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT idx, writer, title, content FROM board WHERE idx =? ";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			rs = ps.executeQuery();
			if( rs.next() ) {    
				boardDTO = new BoardDTO();
				boardDTO.setIdx(idx);                     
				boardDTO.setWriter( rs.getString("writer")); 
				boardDTO.setTitle(rs.getString("title"));    
				boardDTO.setContent(rs.getString("content"));    
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}	
		return boardDTO;
	}
	
	
	
	
	
	// 6. 전체조회
	public List<BoardDTO> selectList(){
		List<BoardDTO> boardLi = new ArrayList<BoardDTO>();
		
		try {
			con=dataSource.getConnection();
			sql = "SELECT idx,writer,title,register FROM board ORDER BY idx DESC";   //목록 정렬을 위해 ORDER BY넣기
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setIdx(rs.getLong("idx"));
				boardDTO.setWriter( rs.getString("writer") );    
				boardDTO.setTitle( rs.getString("title")); 
				boardDTO.setRegister(rs.getDate("register"));    
				boardLi.add(boardDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		
		return boardLi;
	}	
	
}



