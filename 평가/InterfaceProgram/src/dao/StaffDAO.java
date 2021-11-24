package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Staff;
import mybatis.config.DBService;

public class StaffDAO {
private SqlSessionFactory factory;
	
	private static StaffDAO instance;
	private StaffDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static StaffDAO getInstacne() {
		if( instance == null) {
			instance = new StaffDAO();
		}
		return instance;
	}
	
	// 1. 전체 사원 리스트
		public List<Staff> staffList(){
			SqlSession ss = factory.openSession();
			List<Staff> list = ss.selectList("dao.staff.staffList");
			ss.close();
			return list;
		}
	
	// 2. 사원 등록 
		public int staffInsert(Staff staff) {
			SqlSession ss= factory.openSession(false);
			int result = ss.insert("dao.staff.staffInsert", staff);
			if(result>0) ss.commit();
			ss.close();
			return result;
		}
	
	// 3. 사원 검색 (JUNIT)
	public Staff selectStaffBysNo(String sno) {
		SqlSession ss = factory.openSession();
		Staff staff = ss.selectOne("dao.staff.selectStaffBysNo", sno);
		ss.close();
		return staff;
	}
	
	
} // end of class
