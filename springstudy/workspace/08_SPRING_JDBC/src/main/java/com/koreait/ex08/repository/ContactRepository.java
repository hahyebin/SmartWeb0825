package com.koreait.ex08.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.koreait.ex08.domain.Contact;

@Repository
public class ContactRepository {

	
	// Spring jdbc 이용을 위해서 JdbcTemplate 클래스 사용
	// JdbcTemplate 내부에서 Connection, PreparedStatement, ResultSet 사용 (그래서 꺼낼 필요없다)
	@Autowired
	private JdbcTemplate template;
	private String sql;
	
	
	
	
	// DB의 컬럼명과 bean 객체의 속성명이 일치하다면 BeanPropertyRowMapper를 이용하여 자동으로 객체변환을 할 수 있습니다.
	public List<Contact> selectContactList(){
		sql = "SELECT NO, NAME, TEL, ADDRESS, BIRTHDAY FROM CONTACT";
		return template.query(sql, new BeanPropertyRowMapper<Contact>(Contact.class));  // db행 하나하나 행마다 컨텍트에 넣어서 반환
	}
    
	
	
	
	
	// 연락처 삽입
	public int insertContact(Contact contact) {
		return template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 매개변수 Connection con을 이용해서  PreparedStatement ps 만들어서 반환함
				sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, contact.getName());
				ps.setString(2, contact.getTel());
				ps.setString(3, contact.getAddress());
				ps.setString(4, contact.getBirthday());
				return ps;
			}
			
		});
	}
	
	
	// 상세보기
	public Contact selectContactByNo(Contact contact) {
		
		sql = "SELECT NO, NAME, TEL, ADDRESS, BIRTHDAY FROM CONTACT WHERE NO=?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<Contact>(Contact.class), contact.getNo());
		                    // template.queryForObject(sql, rowMapper, args)
	
	}
	
	// 수정하기
	public int updateContact(Contact contact) {
		sql = "UPDATE CONTACT SET TEL = ?, ADDRESS = ?, BIRTHDAY = ?  WHERE NO =? ";
		return template.update(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, contact.getTel());
					ps.setString(2, contact.getAddress());
					ps.setString(3, contact.getBirthday());
					ps.setInt(4, contact.getNo());
					
				}
			});
	}
	
	// 삭제하기
	public int deleteContact(Contact contact) {
		sql = "DELETE FROM CONTACT WHERE NO = ?"; 
			return template.update(sql, new PreparedStatementSetter() {        // PreparedStatementSetter는 	PreparedStatement ps = con.prepareStatement(sql); 안적어줘도 된다
 				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, contact.getNo());
					
				}
			});
	}
	
	
}
