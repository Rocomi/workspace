package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	
	// 서비스 키
	private final String SERVICE_KEY = "";
	
	// air.do 요청을 받을 메소드
	@ResponseBody
	@RequestMapping(value="/air.do", produces="application/json;charset=UTF-8")
	public String airPollution(String location, int pageNo, Model model, HttpSession session) throws IOException {
		
		// 대기오염 정보를 조회 (api 사용)
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"
				+ "?serviceKey="+ SERVICE_KEY 
				+ "&sidoName=" + URLEncoder.encode(location,"UTF-8")
				+ "&returnType=json"
				+ "&numOfRows=10"
				+ "&pageNo="+pageNo;
		
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
	
	// air2.do 요청을 받을 메소드 => xml 형식의 데이터 응답
	@ResponseBody
	@RequestMapping(value="/air2.do", produces="text/xml;charset=UTF-8")
	public String airPollution2(String location, int pageNo, Model model, HttpSession session) throws IOException {
			
			// 대기오염 정보를 조회 (api 사용)
			String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"
					+ "?serviceKey="+ SERVICE_KEY 
					+ "&sidoName=" + URLEncoder.encode(location,"UTF-8")
					+ "&numOfRows=10"
					+ "&pageNo="+pageNo;
			
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
	
	@ResponseBody
	@RequestMapping(value="/temp.do", produces="application/json;charset=UTF-8")
	public String cityTemp (String location, Model model, HttpSession session) throws IOException {
		
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmm");
		 
		int setTime = Integer.parseInt(timeFormat.format(now));
		String searchTime = "";
		
		if (setTime > 1800) {
			searchTime = formatter.format(now) + "1800";
		} else if (setTime > 0600) {
			searchTime = formatter.format(now) + "0600";
		} else {
			cal.setTime(now);
			cal.add(Calendar.DATE, -1);
			searchTime = formatter.format(cal.getTime()) + "1800";
		}
		System.out.println(searchTime);
		
		// 대기오염 정보를 조회 (api 사용)
		String url = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"
				+ "?serviceKey="+ SERVICE_KEY
				+ "&pageNo=1" 
				+ "&dataType=json"
				+ "&numOfRows=10"
				+ "&regId="+ URLEncoder.encode(location,"UTF-8")
				+ "&tmFc=" + searchTime;
		
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

	// 지진해일 긴급대피소 정보 조회
	@ResponseBody
	@RequestMapping(value="/shelter.do", produces="application/json;charset=UTF-8")
	public String getTsunamishelter(int rows, int pageNo) throws IOException {
		
		// 1. 요청 주소
		String url = "https://apis.data.go.kr/1741000/TsunamiShelter4/getTsunamiShelter4List"
					+ "?ServiceKey="+ SERVICE_KEY
					+ "&pageNo=" + pageNo 
					+ "&numOfRows=" + rows
					+ "&type=json";
		
		// 2. 데이터 요청
		URL reqUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)reqUrl.openConnection();
        
        // 3. 응답데이터 추출
        BufferedReader buf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        String responseData = "";
        String line;
        while((line = buf.readLine()) != null) {
        	responseData += line;
        }
        
        buf.close();
        conn.disconnect();
		
		return responseData;
	}
}
