package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.DeleteService;
import model.InsertService;
import model.NameCheckService;
import model.PrevInsertService;
import model.ProductService;
import model.SelectListService;

@WebServlet("*.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProductController() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		ModelAndView mav = null;
		ProductService service = null;
		
		switch(command) {
		case "selectListFrom.do":
			mav = new ModelAndView("views/selectList.jsp", false);
			break;
		case "selectList.do":
			service = new SelectListService();
			break;
		case "insertForm.do":
			mav =  new ModelAndView("views/insert.jsp", false);
			break;
		case "nameCheck.do":
			service = new NameCheckService();
			break;
		case "insert.do":
			service = new InsertService();
			break;
		case "prevInsertName.do":
			service = new PrevInsertService();
			break;
		case "delete.do":
			service = new DeleteService();
			break;
		}
		
		
		if( service != null ) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 if(mav == null){ return; }  // json 사용시 mav는 null임 -> 이동하지 않기 때문에 동작안함 
		
		
			if( mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
