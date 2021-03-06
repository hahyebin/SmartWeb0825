package com.koreait.ex06.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.koreait.ex06.domain.Board;

public class BoardRepository {
	// 필드
	private DataSource dataSource;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// 생성자
	public BoardRepository() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	
   // 메소드
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con!= null) con.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// board의 전체 목록
	public List<Board> selectBoardList(){
		List<Board> list = new ArrayList<Board>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, CREATED, LASTMODIFIED FROM BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next()) {
				Board board = new Board(rs.getLong(1), 
								rs.getString(2), 
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6));
				list.add(board);
			}
		}  catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	
	// 게시판 추가
	public int insertBoard(Board board) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql ="INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
			ps =con.prepareStatement(sql);
			ps.setString(1, board.getWriter());
			ps.setString(2, board.getTitle());
			ps.setString(3, board.getContent());
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
	// 게시판 상세보기
	public Board selectBoardByNo(Long no){
		Board board = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, CREATED, LASTMODIFIED FROM BOARD WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();
			if( rs.next()) {
				board = new Board(rs.getLong(1), 
								rs.getString(2), 
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6));
			}
		}  catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return board;
	}
	
	

	// 게시판 수정
	public int updateBoard(Board board) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql ="UPDATE BOARD SET TITLE=?, CONTENT=?, LASTMODIFIED = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE NO = ?";
			ps =con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setLong(3, board.getNo());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	

	// 게시판 삭제
	public int deleteBoard(Long no) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql ="DELETE FROM BOARD WHERE NO = ?";
			ps =con.prepareStatement(sql);
			ps.setLong(1, no);
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
	
	
} // end of class
