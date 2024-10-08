package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class APIController {
	
	// 서비스 키
	private final String SERVICE_KEY = "Li3JFTX61TxRm4cXFUjRZPENdqEC0YS3rGqMG8GDfqOhNVhZN5eDtGrmko1cyN12rFJnvwOKzNROJEpGgOIwqQ%3D%3D";
	
	// air.do 요청을 받을 메소드
	@ResponseBody
	@RequestMapping(value="/air.do", produces="application/json;charset=UTF-8")
	public String airPollution(String location, Model model, HttpSession session) throws IOException {
		
		// 대기오염 정보를 조회 (api 사용)
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"
				+ "?serviceKey="+ SERVICE_KEY 
				+ "&sidoName=" + URLEncoder.encode(location,"UTF-8")
				+ "&returnType=json"
				+ "&numOfRows=20";
		
		// 요청 주소로 URL 객체를 생성
		URL reqUrl = new URL(url);
		
		// URL 객체를 사용하여 HttpURLConnection 객체 생성
        HttpURLConnection urlConn = (HttpURLConnection)reqUrl.openConnection();
        
        // 요청시 필요한 헤더 정보 세팅
        urlConn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        
        String resText = "";
        String line;
        while((line = br.readLine()) != null) {
        	resText += line;
        }
        
        br.close();
        urlConn.disconnect();
        
        System.out.println(resText);
		
		return resText;
	}

}
