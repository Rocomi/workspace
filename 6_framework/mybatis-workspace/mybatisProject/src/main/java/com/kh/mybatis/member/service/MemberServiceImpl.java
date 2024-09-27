package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.template.MybatisTemplate;

public class MemberServiceImpl implements MemberService {
	private MemberDao mDao = new MemberDao();

	@Override
	public Member loginMember(Member m) {
		Member loginUser = null;
		
		/*
		 * * 기존 JDBC 방식
		 * 		- Connenction 객체 생성
		 * 		- DAO객제에게 전달 (Connection, 요청된 데이터)
		 * 		- 결과에 따라 트랜잭션 처리, Connection 객체 반납(close)
		 * 		- 결과를 반환
		 */
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		loginUser = mDao.loginMember(sqlSession, m);
		
		sqlSession.close();
		
		return loginUser;
	}

	@Override
	public int insertMember(Member m) {
		
		int result = 0;
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = mDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		// rollback : 여러개의 DML문을 실행시키는 경우 필수로 작성해야 하고, 단일행일 경우 생략 가능
		//				ex) 재고 관리, 게시글 등록 (게시글정보+첨부파일)
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public Member updateMember(Member m) {
		Member loginUser = null;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		loginUser = mDao.updateMember(sqlSession, m);
		
		if(loginUser != null) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return loginUser;
	}

	@Override
	public int deleteMember(String id, String pwd) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = mDao.deleteMember(sqlSession, id, pwd);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	public int idCheck(Member m) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = mDao.idCheck(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	public Member updatePassword(String userId, String userPwd, String newPassword) {
		Member loginUser = null;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		loginUser = mDao.updatePassword(sqlSession, userId, userPwd, newPassword);
		
		if(loginUser != null) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return loginUser;
	}

}
