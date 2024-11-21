package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Run {

	public static final String serviceKey = "Li3JFTX61TxRm4cXFUjRZPENdqEC0YS3rGqMG8GDfqOhNVhZN5eDtGrmko1cyN12rFJnvwOKzNROJEpGgOIwqQ%3D%3D"; // 생략


	public static void main(String[] args) throws IOException {


		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

		url += "?serviceKey="+ serviceKey 
			+ "&sidoName=" + URLEncoder.encode("서울","UTF-8")
			+ "&returnType=json";

		URL requestUrl = new URL(url);	
	        	HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
	        	urlConnection.setRequestMethod("GET");

	        	BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	        
		String responseText = "";
	        	String line;
	        	while((line = br.readLine()) != null) {
	        		responseText += line;
	        	}
	        	br.close();
	        	urlConnection.disconnect();
		 System.out.println(responseText);

}

}
