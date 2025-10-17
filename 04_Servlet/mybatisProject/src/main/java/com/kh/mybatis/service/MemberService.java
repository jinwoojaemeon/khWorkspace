package com.kh.mybatis.service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.dao.MemberDao;
import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.common.Template;


public class MemberService {
	private MemberDao memberDao = new MemberDao();
	
	
	public Member loginMember(String userId, String userPwd) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member m = memberDao.loginMember(sqlSession, userId, userPwd);
		
		sqlSession.close();
		
		return m;
	}
	
	public int idCheck(String checkId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int count = memberDao.idCheck(sqlSession, checkId);
		sqlSession.close();
		return count;
	}
	
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = memberDao.insertMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}
	
	
	public Member updateMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = new MemberDao().updateMember(sqlSession, m);
		
		Member updateMember = null;
		if(result > 0) {
			sqlSession.commit();
			updateMember = new MemberDao().selectMemberByUserId(sqlSession, m.getMemberId());
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updateMember;
	}
	
	public Member updateMemberPwd(String memberId, String updatePwd) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = new MemberDao().updateMemberPwd(sqlSession, memberId, updatePwd);
		
		Member updateMember = null;
		if(result > 0) {
			sqlSession.commit();
			updateMember = new MemberDao().selectMemberByUserId(sqlSession, memberId);
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return updateMember;
	}
	
	public int deleteMember(String userId) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = new MemberDao().deleteMember(sqlSession, userId);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}
}
