package service.comments;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import common.Page;
import dao.CommentsDao;
import dto.Comments;

public class CommentsListService implements CommentsService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long bNo = Long.parseLong(request.getParameter("bNo"));
		
		// 파라미터 page
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 댓글의 총 수 
		int totalCount = CommentsDao.getInstance().selectTotalCount(bNo);
		
		// page 객체
		Page p = new Page();
		p.setPageEntity(totalCount, page);
		
		// HashMap
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("beginRecord", Long.valueOf(p.getBeginRecord()));
		map.put("endRecord",  (long)p.getEndRecord());
		map.put("bNo", bNo);
		
		// 목록가져오기
		List<Comments> list = CommentsDao.getInstance().selectCommentsList(map);
		
		// 로그로 데이터 확인하기
		Logger logger = Logger.getLogger(CommentsListService.class.getName());
		logger.info(list.toString());
		
		// 반환할 JSON
	   JSONObject result = new JSONObject();       // JSONArray를 담기 위해 JSONObject를  추가 
	   result.put("commentsCount", list.size());  		 // 전달1. 댓글 수 저장 
	   
		JSONArray comments = new JSONArray();
		for(Comments comment : list) {
			JSONObject obj = new JSONObject();
			obj.put("cNo", comment.getcNo());
			obj.put("writer", comment.getWriter());
			obj.put("content", comment.getContent());
			obj.put("bNo", comment.getbNo());
			obj.put("state", comment.getState());
			obj.put("created", comment.getCreated());
			comments.put(obj);
		}
		result.put("comments", comments);     		 	 // 전달2  댓글 내용 저장 
	
		JSONObject pageEntity = new JSONObject(p);   	 //  전달3. Page객체 전달
		result.put("pageEntity",pageEntity);
		
		/**    result
		 	{
		 		"commentsCount" : 2,
		 		"comments" : [
			 			{
			 				"cNo" : 1,
			 				"writer" : "admin",
			 				"content" : "첫번째댓글",
			 				"bNo" : 1,
			 				"state" : 0,
			 				"created" : "2021-11-29"
			 			},
			 			{
			 				"cNo" : 2,
			 				"writer" : "apple",
			 				"content" : "두번째댓글",
			 				"bNo" : 1,
			 				"state" : 0,
			 				"created" : "2021-11-29"
			 			},
		 			]
		 		"pageEntity" : {
		 				"totalRecord" : 2,
		 				"recordPerPage" : 10,
		 				"totalPage" : ,
		 				"page" : ,
		 				"beginRecord" : ,
		 				"endRecord" :  ,
		 				"pagePerBlock" : 5,
		 				"beginPage" : ,
		 				"endPage" : 
		 		}
		 			
		 	} // json
		  
		 **/
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);                 // result에  모든 내용 담았기 대문에 반환할 내용은 comments가 아닌 result다
		out.close();
		
		
		

	}

}
