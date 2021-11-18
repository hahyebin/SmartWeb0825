package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;

public class MemberDao {
	private SqlSessionFactory factory;
	
	/* singleton */
	private static MemberDao instance;
	private MemberDao() {
		factory = DBService.getInstance().getFactory();          // DBService 싱글톤 패턴의 객체를 위해 getInstance() 호출을 통해 객체 생성하고, getFactory를 호출해서 factory를 얻어온다.
	}
	public static MemberDao getInstance() {
		if(instance == null ) {
			instance = new MemberDao();
		} return instance;
	}
	
	// 1. 로그인하면 멤버 갖고오기
	public Member selectMember(Member member) {
		SqlSession ss = factory.openSession();
		Member user = ss.selectOne("dao.member.selectMember", member);
		ss.close();
		return user;
	}

	// 2. 로그인 기록 남기기
	public int loginLog(String id) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.loginLog", id);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 3. 회원가입하기 + 중복체크는 1번쿼리활용함 
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.insertMember", member);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
}// end of class
