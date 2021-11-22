package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Free;
import mybatis.config.DBService;
import oracle.net.aso.f;

public class FreeDao {
	private SqlSessionFactory factory;
	
	/* singleton */
	private static FreeDao instance;
	private FreeDao() {
		factory = DBService.getInstance().getFactory();          // DBService 싱글톤 패턴의 객체를 위해 getInstance() 호출을 통해 객체 생성하고, getFactory를 호출해서 factory를 얻어온다.
	}
	public static FreeDao getInstance() {
		if(instance == null ) {
			instance = new FreeDao();
		} return instance;
	}
	
	// list
	public List<Free> selectFreeList(){
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("dao.free.selectFreeList");
		ss.close();
		return list;
	}
	
	// 총 게시물 수
	public int selectTotalCount() {
		SqlSession ss = factory.openSession();
		int result = ss.selectOne("dao.free.selectTotalCount");
		ss.close();
		return result;
	}
	
	// 새글 등록 
	public int insertFree(Free free) {
		SqlSession ss= factory.openSession(false);
		int result = ss.insert("dao.free.insertFree", free);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 상세보기
	public Free selectFreeByfNo(Long fNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne("dao.free.selectFreeByfNo", fNo);
		ss.close();
		return free;
	}
	
	
	// 조회수
	public int updateHit(Long fNo) {
		SqlSession ss= factory.openSession(false);
		int result = ss.update("dao.free.updateHit", fNo);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 수정하기
	public int updateFree(Free free) {
		SqlSession ss= factory.openSession(false);
		int result = ss.update("dao.free.updateFree", free);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
	
	
}// end of class
