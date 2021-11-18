package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Reply;
import mybatis.config.DBService;

public class ReplyDao {
	private SqlSessionFactory factory;
	
	/* singleton */
	private static ReplyDao instance;
	private ReplyDao() {
		factory = DBService.getInstance().getFactory();          // DBService 싱글톤 패턴의 객체를 위해 getInstance() 호출을 통해 객체 생성하고, getFactory를 호출해서 factory를 얻어온다.
	}
	public static ReplyDao getInstance() {
		if(instance == null ) {
			instance = new ReplyDao();
		} return instance;
	}
	
	// 1. 댓글 삽입
	public int insertReply(Reply reply) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.reply.insertReply", reply);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 2. 리스트 (NoticeViewService에 있음)
	public List<Reply> selectReplyList(Long nNo){
		SqlSession ss = factory.openSession();
		List<Reply> list = ss.selectList("dao.reply.selectReplyList", nNo);
		ss.close();
		return list;
	}
	
	
	
	
}// end of class
