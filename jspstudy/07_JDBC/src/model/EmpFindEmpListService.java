package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;

public class EmpFindEmpListService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		EmpDAO empDAO = EmpDAO.getInstance();					  // empDAO 객체 생성 
		request.setAttribute("empList", empDAO.selectEmpList());  // jsp로 보내줄 결과=>empDAO.selectEmpList() 
		
		
		return new ModelAndView("views/selectEmpList.jsp", false); // 매개변수 있는 생성자를 만듦과 동시에 리턴함 -> 첫번째 파라미터인 view는 이동경로, 두번째는 전달방법(forward or request) 
		
	}

}
