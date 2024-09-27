package com.kh.mybatis.member.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
		/*
		Member loginUser = null;
		
		loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		// selectOne() : 조회된 결과가 없을경우 null을 반환
		
		return loginUser;
		*/
		
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	/*
	 * sqlSession 객체에서 제공하는 메소드를 통해 sql문을 실행하고 결과를 바로 받음
	 * 
	 * 결과 = sqlSession.SQL문 종류에 맞는 메소드("매퍼의별칭.sql문의id"[, sql문 실행 시 필요한 데이터])
	 */

	public int idCheck(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.idCheck", m);
	}

	public int deleteMember(SqlSession sqlSession, String id, String pwd) {
		Member m = new Member();
		m.setUserId(id);
		m.setUserPwd(pwd);
		return sqlSession.update("memberMapper.deleteMember", m);
	}

	public Member updateMember(SqlSession sqlSession, Member m) {
		sqlSession.update("memberMapper.updateMember", m);

		return sqlSession.selectOne("memberMapper.selectMember", m);
	}

	public Member updatePassword(SqlSession sqlSession, String userId, String userPwd, String newPassword) {
		
		HashMap<String,String> updatePass = new HashMap<>();
		updatePass.put("userId", userId);
		updatePass.put("userPwd", userPwd);
		updatePass.put("newPassword", newPassword);
		
		sqlSession.update("memberMapper.updatePassword", updatePass);
		
		return sqlSession.selectOne("memberMapper.selectMember", updatePass);
	}

}
