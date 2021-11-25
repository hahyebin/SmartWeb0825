package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Free;
import mybatis.config.DBService;

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
	
	
	
	// list + 페이징처리를 위한 map 전달
	public List<Free> selectFreeList(Map<String,Integer> map){
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("dao.free.selectFreeList", map);
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
	// 삭제하기 (실삭제는 아님)
	public int deleteFree(Long fNo) {
		SqlSession ss= factory.openSession(false);
		int result = ss.update("dao.free.deleteFree", fNo);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// ****************댓글 관련 = 삽입  *************************
	public int insertReply(Free reply) {
		SqlSession ss= factory.openSession(false);
		int result = ss.insert("dao.free.insertReply", reply);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// *********** 댓글 관련 = 정렬위한 groupOrd(update위해  원글의 groupNo 와 groupOrd가 필요하기 때문에 인자로 free객체를 받는다(원글) **********
	public int updatePreviousReplyGroupOrd(Free free) {
		SqlSession ss= factory.openSession(false);
		int result = ss.update("dao.free.updatePreviousReplyGroupOrd", free);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	// ************** 검색기능 ***********************************
	public List<Free> findFree(Map<String, Object> map) {
		SqlSession ss = factory.openSession();
		List<Free> list = ss.selectList("dao.free.findFree", map);
		ss.close();
		return list;
	}
	
	
	// ************** 검색기능 : 게시글 수 ********************************
	public int selectFindCount(Map<String, Object> map){
		SqlSession ss = factory.openSession();
		int count = ss.selectOne("dao.free.selectFindCount", map);
		ss.close();
		return count;
	}
	
}// end of class
