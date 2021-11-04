package model;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lotto {
	
	
	public void excute(HttpServletRequest request,  HttpServletResponse response) {	
		Set lotto = new HashSet();
        for(int i=0; i<6; i++){
            int a = (int)(Math.random()*45)+1;
            lotto.add(a);
        }
		}
    	String result = lotto.toString();
		request.setAttribute("result",  result);
	}

