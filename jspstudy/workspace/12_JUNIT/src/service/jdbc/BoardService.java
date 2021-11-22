package service.jdbc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	// IOException은 예외처리 하지 않는다 - > try - catch로 함 
	// ModelAndView 가 없기 때문에 결과처리는 response로 한다 -> getWriter -> 입출력스트림 사용때문에 -> IOException 
}
