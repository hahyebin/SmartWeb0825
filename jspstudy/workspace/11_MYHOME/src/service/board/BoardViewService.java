package service.board;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;
import dto.Board;

public class BoardViewService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터 
		Optional<String> opt = Optional.ofNullable(request.getParameter("bNo"));
		Long bNo = Long.parseLong(opt.orElse("0"));
		
		// DB에서 board 가져오기 
		Board board = BoardDao.getInstance().selectBoardView(bNo);
		
		
		
		// 결과가 있다면 
		if( board != null ) {
			// view.jsp로 보낼 데이터 저장 
			request.setAttribute("board", board);
			request.setAttribute("year", new SimpleDateFormat("yyyy").format(board.getLastModified()));   // db에서 date 타입으로 저장했기 때문에 String type로 변환시켜 view jsp 에서 바로 사용할 수 있게 만든다.
			request.setAttribute("month", new SimpleDateFormat("MM").format(board.getLastModified()));
			request.setAttribute("day", new SimpleDateFormat("dd").format(board.getLastModified()));
			return new ModelAndView("board/view.jsp", false);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시글 정보 확인 불가')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}
