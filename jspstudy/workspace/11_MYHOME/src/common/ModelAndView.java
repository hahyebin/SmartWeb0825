package common;

// 어디로 어떻게 이동할 것이지 저장하는 클래스
public class ModelAndView {
	
	private String view;		 //어디로 이동할 것인가?
	private boolean isRedirect;  // 어떻게 이동할 것인가? true이면 redirect, false이면 forward

	public ModelAndView() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ModelAndView(String view, boolean isRedirect) {
		super();
		this.view = view;
		this.isRedirect = isRedirect;    // 매개변수 생성자가 있어야 service에서 바로 return 가능 
	}


	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
	
	
}
