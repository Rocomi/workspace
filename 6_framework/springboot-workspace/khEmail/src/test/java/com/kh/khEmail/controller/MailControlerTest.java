package com.kh.khEmail.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.kh.khEmail.service.MailService;

// @WebMvcTest : 테스트시 사용되는 어노테이션
@WebMvcTest(MailController.class)
public class MailControlerTest {
	
	@Autowired
	private MockMvc mockMvc;
	// => Spring MVC 컨트롤러 테스트를 위한 클래스 (Http 요청 시뮬레이션/응답 검증)
	
	@MockBean
	private MailService mService;
	// => 테스트용으로 만들어서 사용. 실제로 동작되지 않고 동작되는 것 처럼 처리됨!
	
	@Test	// 테스트용 메소드
	void authMailTest() throws Exception {
		
		mockMvc.perform(
					post("/mail")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"email\":\"rlekdns@gmail.com\"}")
				)
		.andExpect(status().isOk());
	}
	
	@Test
	void codeCheckTest() throws Exception {
		mockMvc.perform(
				post("/check")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\":\"rlekdns@gmail.com\", \"code\":\"asdf asdf asdf asdf\"}")
			)
	.andExpect(status().isOk());
	}
	
	
	 @Test
	    @DisplayName("사용자 정보 삭제 테스트")
	    void deleteUser() throws Exception {
	        mockMvc.perform(
	                post("/test")
	                        .param("id","hong00")
	        )
	                .andExpect(status().isOk());
	    }
	
}
