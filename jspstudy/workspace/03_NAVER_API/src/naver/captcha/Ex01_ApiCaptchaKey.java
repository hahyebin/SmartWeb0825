package naver.captcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


public class Ex01_ApiCaptchaKey {

	public static void main(String[] args) {
		
		String clientId = "EfI8HhY51r1KSViceL9i";
		String clientSecret = "j6dttir_jK";
		
		String code = "0";   //  키 발급 "0", 이미지 비교 "1"
		String apiURL ="https://openapi.naver.com/v1/captcha/nkey?code="+code;
	
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
//			con.setRequestProperty("X-Naver-Client-Id", clientId);  key+value = entry    ==> entrySet() : entry // entry.getkey()  //  entry.getValue()
//			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			int responseCode = con.getResponseCode();
			if( responseCode == HttpURLConnection.HTTP_OK) { // == 200 (HTTP_OK는 HttpURLConnection객체의 스테틱필드값으로가짐)
			  // 데이터 받아오기위한 스트림 
				InputStreamReader isr = new InputStreamReader(con.getInputStream());  // 내용을 읽지못하는 예외발생 
				BufferedReader br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();								// 한줄씩 텍스트 읽을 때
				while(true) {
					String line = br.readLine(); // 한 줄 읽기 
					if(line == null) {
						break;  // line 읽을 게없으면 null
					}
					sb.append(line);  // sb객체 문자 읽기 위해 toString()
				}
				System.out.println("네이버로부터 반환 받은 데이터 : "+ sb.toString());
				JSONObject obj = new JSONObject(sb.toString());
				String captchaKey = (String) obj.get("key");
				System.out.println(captchaKey);
				
			} else  {																	// 네이버로부터 반환 받은 에러 
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main()

} 
