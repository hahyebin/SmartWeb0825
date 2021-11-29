package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Comments;
import mybatis.config.DBService;

public class CommentsDao {
	private SqlSessionFactory factory;
	
	/* singleton */
	private static CommentsDao instance;
	private CommentsDao() {
		factory = DBService.getInstance().getFactory();          // DBService 싱글톤 패턴의 객체를 위해 getInstance() 호출을 통해 객체 생성하고, getFactory를 호출해서 factory를 얻어온다.
	}
	public static CommentsDao getInstance() {
		if(instance == null ) {
			instance = new CommentsDao();
		} return instance;
	}
	
	// 1. 댓글 등록
	public int insertComments(Comments comment) {
		SqlSession ss= factory.openSession(false);
		int result = ss.insert("dao.comments.insertComments", comment);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}

	//  댓글 수
	public int selectTotalCount(Long bNo){
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.comments.selectTotalCount", bNo);
		ss.close();
		return totalCount;
	}
	
	// 2. 댓글 리스트
	public List<Comments> selectCommentsList(Map<String, Long> map){
		SqlSession ss = factory.openSession();
		List<Comments> list = ss.selectList("dao.comments.selectCommentsList", map);
		ss.close();
		return list;
	}
	
	// 3. 댓글 삭제 
	public int deleteComments(Long cNo) {
		SqlSession ss= factory.openSession(false);
		int result = ss.update("dao.comments.deleteComments", cNo);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
}// end of class
