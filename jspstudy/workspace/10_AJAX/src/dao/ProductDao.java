package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Product;
import mybatis.config.DBService;

public class ProductDao {
	private SqlSessionFactory factory;
	
	private static ProductDao instance;
	private ProductDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static ProductDao getInstance() {
		if( instance == null ) {
			instance = new ProductDao();
		} return instance;
	}
	
	
	// 1. 제품 목록 
	public List<Product> selectList(){
		SqlSession ss = factory.openSession();
		List<Product> list = ss.selectList("dao.product.selectList");
		ss.close();
		return list;
	}
	
	// 2. 제품명 중복 체크  ==> 반환타입은 false/true
	public boolean nameCheck(String name) {
		SqlSession ss = factory.openSession();
		Product product = ss.selectOne("dao.product.nameCheck", name);  //매개변수있으면 매개변수 꼭 넣기 ==> SQL 에러남!
		ss.close();
		return product == null;   // 조회했는데 product객체 없으면 null로 반환함  ====> null == null  ==> true가 나오면 동일 제품없음 
	}

	// 3. 제품 등록 
	public int insert(Product product) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.product.insert", product);
		if(result>0) ss.commit();
		ss.close();
		return result;
	}
	
	// 4. 마지막 제품 확인 
	public Product prevInsert() {
		SqlSession ss = factory.openSession();
		Product product = ss.selectOne("dao.product.prevInsert");
		ss.close();
		return product;
	}
	// 4. 마지막 제품 확인  -  String ver 
	public String preInsert2() {
		SqlSession ss = factory.openSession();
		Product product = ss.selectOne("dao.product.prevInsert");
		ss.close();
		return product.getName();
	}
	
	// 5. 제품 삭제
	public int delete(Long pno) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.product.delete", pno);
		if(result> 0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
	
}  // end of class
