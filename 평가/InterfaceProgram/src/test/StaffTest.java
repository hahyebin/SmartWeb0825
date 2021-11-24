package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.StaffDAO;
import dto.Staff;

class StaffTest {
	
 @BeforeEach
	void 테스트전()  {
		Staff staff = new Staff();
		staff.setsNo("88877");
		staff.setName("테스트");
		staff.setDept("테스트부서");
		
		int result = 0;
		try {
			result = StaffDAO.getInstacne().staffInsert(staff);
		} catch (Exception e) { 
			assertEquals(1, result, "사원 등록에 문제가 있습니다.");
	   }
 }
	@Test
	void test() {
		Staff staff = StaffDAO.getInstacne().selectStaffBysNo("88877");
		assertNotNull(staff, "사원 검색에 문제가 있습니다.");
		
	}

}
