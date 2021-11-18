package mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


// SqlSessionFactory를 만들어서 Dao에게 반환하는 클래스 



public class DBService {
	/* SqlSessionFactory */
	private SqlSessionFactory factory;
	public SqlSessionFactory getFactory() { return factory; }
	
	
	// singleton 
	/* SqlSessionFactory는 애플리케이션을 실행하는 동안 존재(삭제, 재생성x) 다시 생성하는 건 좋지 않음
	 * 그래서 싱글톤으로 관리하는 것이 가장 베스트
	 */
	private static DBService instance;
 
	private DBService() {
 		/* SqlSessionFactory를 Build */
		try {
			 String resource = "mybatis/config/mybatis-config.xml";  // db접속을 위한 기본정보
			 InputStream inputStream = Resources.getResourceAsStream(resource);  // 읽어서 
	 		 factory = new SqlSessionFactoryBuilder().build(inputStream);		//factory 만듦      DBService 객체가 생성될 때 SqlSessionFactory 생성
		} catch (IOException e) {
			e.printStackTrace();
		}
	
 	}
 	public static DBService getInstance() {
 		if(instance == null ) {
 			instance = new DBService();
 		}return instance;
 	}

 	

 	
} // end of class
