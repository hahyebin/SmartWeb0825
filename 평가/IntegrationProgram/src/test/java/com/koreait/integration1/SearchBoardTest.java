package com.koreait.integration1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import junit.framework.Assert;

public class SearchBoardTest {

	@Test
	public void test() {
		try {
			String pass = "영화";     // encode(pass) => test 성공
			String fail = "액션";    // encode(fail) => test 실패
			String apiURL = "http://localhost:9090/integration1/movie/findMovie?column=TITLE&query="+URLEncoder.encode((pass), "UTF-8");
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ( (line = br.readLine()) != null ) {
				sb.append(line);
			}
			JSONObject obj = new JSONObject(sb.toString());
		//	System.out.println("status : " + obj.getInt("status"));
			if(  obj.getInt("status") == 200 ) {                   // 200 (성공) 일때만 콘솔 출력 
				JSONArray arr = obj.getJSONArray("list");
		        for (int i = 0; i < arr.length(); i++) {
					JSONObject o = arr.getJSONObject(i);
					System.out.println("번호 : " + o.getInt("no"));
					System.out.println("제목 : " + o.getString("title"));
					System.out.println("내용 : " + o.getString("content"));
					System.out.println("작성일: " + o.getString("regDate"));
				
					System.out.println();
				  }
	        }
			if(  obj.getInt("status") == 500 ) {                // 500 (실패) 일때 fail 실행
				 Assert.fail(obj.getString("message"));
				
			}
			
 		} catch(Exception e) {
			e.printStackTrace();
		}	
	}


}
