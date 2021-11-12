package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.sun.scenario.effect.impl.prism.PrDrawable;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class PrevInsertService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Product product = ProductDao.getInstance().prevInsert();
		
		// JSONobject객체
		JSONObject obj = new JSONObject();
		obj.put("name", product.getName());
		
		// JSONObject obj
		// {"name" : "마지막 과자이름"}
		
		// ajax
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
	
		return null;
	}

}
