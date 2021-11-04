package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuGudan {

	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
	StringBuilder sb = new StringBuilder();
		String a = "";
		
		for( int dan=2; dan<=9; dan++) {
			for(int n=1; n<=9; n++) {
		     a = dan +"X"+n+"="+(dan*n)+"<br>";
		
		     sb.append(a);	
			}
		}
		
		String result = sb.append(a).toString();	
		request.setAttribute("result",result);
	
		}
	
	}
