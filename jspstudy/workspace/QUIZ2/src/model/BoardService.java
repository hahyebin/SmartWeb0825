package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;


// 메소드 중복으로 인터페이스 생성
public interface BoardService {
  public ModelAndView execute(HttpServletRequest request, HttpServletResponse response);
}
