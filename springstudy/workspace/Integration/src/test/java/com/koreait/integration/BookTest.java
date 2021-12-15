package com.koreait.integration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class BookTest {

	@Test
	public void 전체목록_테스트() {
	    
		try {
			
			String apiURL = "http://localhost:9090/integration/book/findAllBook";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while( (line = br.readLine()) != null ) {
				sb.append(line);
			}
			//System.out.println(sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			System.out.println("status : "+obj.getInt("status"));
			System.out.println(" ");
			System.out.println("message : "+obj.getString("message"));
			System.out.println(" ");
			JSONArray arr = obj.getJSONArray("list");
			for( int i=0; i<arr.length(); i++) {
				                                     // arr[i]=JSONObject이다.          제이슨오브젝트안에 list가 있고 list는 제이슨오브젝트이기 때문에 한번 더 꺼내서 확인해야한다. list가 배열이기 때문에 for문 돌려야 확인 가능
			JSONObject o =	arr.getJSONObject(i);    // getJSONObject()은 제이슨 객체를 꺼낼수있다.
			System.out.println("번호 : " + o.getInt("no"));
			System.out.println("제목 : " + o.getString("title"));
			System.out.println("개요 : " + o.getString("preview"));
			System.out.println("저자 : " + o.getString("author"));
			System.out.println("가격 : " + o.getInt("price"));
			System.out.println(" ");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
