package naver.captcha;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Ex02_ApiCaptchaImage {

	public static void main(String[] args) {
		String clientId = "EfI8HhY51r1KSViceL9i";
		String clientSecret = "j6dttir_jK";

		String key = "uFVaVUZa8IKdySk4";
		
		String apiURL ="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key="+key;
		
		// 요청 헤더(request header) : 아이디, 시크릿 
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);  						 // 주소가 틀릴수도 있기 때문에 예외 발생  // 연결하지 못한 예외발생 
			con = (HttpURLConnection)url.openConnection();   // openConnection()는 반환타입이 URLConnection이다. 
															 //  URLConnection은 HttpURLConnection의 조상이고, (자손)con = url.openConnection()(조상)일때는 다운캐스팅으로 형변환이 필수다.
			con.setRequestMethod("GET");    				 // get / post
			for( Map.Entry<String,String> entry : requestHeaders.entrySet() ) {
				con.setRequestProperty( entry.getKey(),  entry.getValue());
			}
			
			int responseCode = con.getResponseCode();
			if( responseCode == HttpURLConnection.HTTP_OK) { // == 200 (HTTP_OK는 HttpURLConnection객체의 스테틱필드값으로가짐)
			  // 이미지를 받아오는 부분 
				BufferedInputStream bis = new BufferedInputStream(con.getInputStream()); //이미지읽기
				String filename = Long.valueOf((new Date()).getTime()).toString() + ".jpg";   // Long.valueOf((new Date()).getTime()) 다운 시간 
				File file = new File(filename);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				byte[] b = new byte[1024];
				int readCount = 0;
				while( true) {
					readCount = bis.read(b);   // bis.read(b)를 읽다가 읽을게 없으면 -1이 되고 그때 멈춰야함!!
					if( readCount == -1 ) {
						break;
					}
					bos.write(b, 0, readCount);  // b배열에서 0인덱스부터 실제로 읽은 만큼만 읽겠다 // -> 그냥 읽으면 실제 읽지 않은 나머지 1024-x 만큼을 갖고온다 즉 쓰레기를 갖고옴 그래서 실제 바이트를 갖고 오게하기 위해 readCount를 변수를 만든다. 
				}
				System.out.println(filename+"이미지 캡차가 생성되었습니다.");
				if( bos != null) { bos.close();  }
				if( bis != null) { bis.close();  }
			} else  {																	// 네이버로부터 반환 받은 에러 // 이미지의 실패는 문자열로만 받기 때문에 기존 스트림 
				InputStreamReader isr = new InputStreamReader(con.getErrorStream());    // 에러코드 읽어서 반환 
				BufferedReader br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();								
				while(true) {
					String line = br.readLine(); // 한 줄 읽기 
					if(line == null) {
						break;  // line 읽을 게없으면 null
					}
					sb.append(line);  // sb객체 문자 읽기 위해 toString()
				}
				System.out.println("네이버로부터 반환 받은 에러데이터 : "+ sb.toString());
			}
			
		} catch(MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiURL, e);  //	url = new URL(apiURL);  /
		} catch(IOException e) {
			throw new RuntimeException("연결이 실패했거나 API응답을 읽는데 실패했습니다. : "+ apiURL, e);
		} finally {
				con.disconnect();   // con 연결 닫아주기 
		}

		
	}
}
