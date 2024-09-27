package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		// 기본 생성자를 통해 Member 타입의 객체를 생성
		
		Member m = new Member();
		
		// changeName을 이용해 값을 변경
		// m.membername = "엄희윤" --> private으로 접근제한
		m.changeName("엄희윤");
		
		// printName을 이용해 출력
		//System.out.println(m.memberName); --> 접근제한
		m.printName();

	}

}