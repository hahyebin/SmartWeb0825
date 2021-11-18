package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BBoardService {
	public  ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
