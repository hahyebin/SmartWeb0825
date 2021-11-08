package common;
            //데이터를 저장해서 실어 나르는 역할(Bean)
public class ModelAndView {
	
	// String view : 응답 View 
	// boolean isRedirect : true(redirect) / false(forward)
	
	private String view;
	private boolean isRedirect;
	
	public ModelAndView() {
		
	}
	public ModelAndView(String view, boolean isRedirect) {
		super();
		this.view = view;
		this.isRedirect = isRedirect;
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
