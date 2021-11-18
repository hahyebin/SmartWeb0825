package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Rreply;
import mybatis.config.MybatisSetting;

public class RReplyDao {
	private SqlSessionFactory factory;
	
	private static RReplyDao instance;
	private RReplyDao(){
		factory = MybatisSetting.getInstance().getFactory();
	}
	
	public static RReplyDao getInstance() {
		if( instance == null ) {
			instance = new RReplyDao();
		}return instance;
	}

	// 1. 댓글리스트 
	public List<Rreply> selectListReply(Long idx){
		SqlSession ss = factory.openSession();
		List<Rreply> list = ss.selectList("dao.rreply.selectListReply", idx);
		ss.close();
		return list;
	}
	// 2. 댓글삽입 
	public int insertReply(Rreply reply) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.rreply.insertReply", reply);
		if( result > 0 ) ss.commit();
		ss.close();
		return result;
	}
	
} // end of class

