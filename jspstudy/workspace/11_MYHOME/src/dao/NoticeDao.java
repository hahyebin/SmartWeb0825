package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Notice;
import mybatis.config.DBService;

// data access object  -> 데이터 접근 객체 
public class NoticeDao {
	
	// MyBatis는 SqlSession 객체를 이용해서 DB에 접근한다.
	// SqlSession 객체는 메소드 별로 만들고 닫는 것이 좋다.  => SqlSession 객체는 thread safe에 속해있지 않기 때문에 메소드별로 만든다.  
	   // thread safe는 하나의 객체를 멀티(여러)스레드가 실행될때 사용해도 안전하게 작동하다는 것
	   // => 객체가 여러 스레드로부터 동시에 접근이 이루어져도 프로그램의 실행에 문제가 없음을 뜻한다.)
	// SqlSession 객체를 만들 수 있는 SqlSessionFactory를 준비해 둔다.
	private SqlSessionFactory factory;
	
	/* singleton */
	private static NoticeDao instance;
	private NoticeDao() {
		factory = DBService.getInstance().getFactory();          // DBService 싱글톤 패턴의 객체를 위해 getInstance() 호출을 통해 객체 생성하고, getFactory를 호출해서 factory를 얻어온다.
	}
	public static NoticeDao getInstance() {
		if(instance == null ) {
			instance = new NoticeDao();
		} return instance;
	}
	
	// SqlSession 각 스레드는 자체적으로  SqlSession 인스턴스를 가짐(공유x) -> static 지정 불가 -> SqlSession은 thread-safe에 속해있지 않기 때문이다.
	
	// 1. 전체 목록 리스트
	public List<Notice> selectNoticeList(){
		SqlSession ss = factory.openSession();
		List<Notice> list = ss.selectList("dao.notice.selectNoticeList");
		ss.close();
		return list;
	}
	
	// 2. 공지사항 숫자를 받아서 한 공지사항 객체를 갖고옴!
	public Notice selectNoticeView(Long nNo) {
		SqlSession ss = factory.openSession();
		Notice notice = ss.selectOne("dao.notice.selectNoticeView", nNo);
		ss.close();
		return notice;
	}
	
	// 3. 조회수
	public int updateNoticeHit(Long nNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.notice.updateNoticeHit", nNo);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 4. 게시글 등록 
	public int insertNotice(Notice notice) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.notice.insertNotice", notice);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}	
	
	// 5. 게시글 수정 
	public int updateNotice(Notice notice) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.notice.updateNotice", notice);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	// 6. 게시글 삭제
	public int deleteNotice(Long nNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.notice.deleteNotice", nNo);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
	
	
	
} // end of class
