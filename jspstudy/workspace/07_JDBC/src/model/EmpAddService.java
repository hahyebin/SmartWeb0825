package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;
import dto.EmpDTO;

public class EmpAddService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
//		
//		EmpDTO empDTO = new EmpDTO();
//		empDTO.setName(name);
		
		EmpDTO empDTO = new EmpDTO(name);
		
		EmpDAO empDAO = EmpDAO.getInstance();
		int result = empDAO.insertEmp(empDTO);  // => 반환타입 1 이나 0의 정수 존재
		
		ModelAndView modelAndView = null;
		if( result>0) {  // if(result==1)
			modelAndView =  new ModelAndView("/JDBC/selectList.emp", true );    // DB 수정 이후에는 redirect할 것 (삽입 수정 삭제는 redirect!!!!!!!!!!!)
			                                                                    // 데이터 추가 후 디비 재호출해야 다시 목록을 가져와야 갱신가능하기 때문에 바로 views/selectEmpLit.jsp 로 이동하면 안된다.
											// selectList 맵핑을 가서 다시 리스트 추가 후 갖고 와야한다.
		} else {
			// 경고창 띄우기 
		}
		
		return modelAndView;
	}

}
