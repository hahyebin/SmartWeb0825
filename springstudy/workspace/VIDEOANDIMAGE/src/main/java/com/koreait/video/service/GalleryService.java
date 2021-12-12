package com.koreait.video.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.video.domain.Video;
// service -> repository
public interface GalleryService {
	
	
	// abstract method;
	public List<Video> selectGalleryList();		
	public Video selectGalleryByNo(Long no);     
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);      
	public int updateGallery(Video gallery);     
	public int deleteGallery(Long no);		
	
	
	
	// default method
	// 응답 중복 회피 위한 메서드 
		public default void message(int result, HttpServletResponse response,
						String success, String fail, String path) {
			try {			
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				if( result > 0 ) {
					out.println("<script>");
					out.println("alert('"+success+"')");
					out.println("location.href='"+path+"'");
					out.println("</script>");
				} else {
					out.println("<script>");
					out.println("alert('"+fail+"')");
					out.println("history.back();");
					out.println("</script>");
				}
				out.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}
