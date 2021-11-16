package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDAO {
	private SqlSessionFactory factory;
	
	private static MemberDAO instance;
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
		}
	public static MemberDAO getInstance() {
		if( instance == null ) {
			instance = new MemberDAO();
		} return instance;
	}
	
	
	// 전체 리스트 
	public List<MemberDTO> selectList(){
		SqlSession ss = factory.openSession();
		 List<MemberDTO> list = ss.selectList("dao.members.selectList");
		 ss.close();
		 return list;
	}
	
	// point top
	public List<MemberDTO>  selectTopList() {
		SqlSession ss = factory.openSession();
		List<MemberDTO> list= ss.selectList("dao.members.selectTopList");
		ss.close();
		 return list;
	}
	
	// 회원 한명 확인?
	public MemberDTO select(MemberDTO member) {
		SqlSession ss = factory.openSession();
		MemberDTO mem = ss.selectOne("dao.members.select", member);
		ss.close();
		return mem;
	}
	
	// 회원 가입 
	public int insert(MemberDTO member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.members.insert", member);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 탈퇴
	public int delete(int no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.members.delete", no);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 수정 
	public int update(MemberDTO member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.members.update", member);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
} // end of class
