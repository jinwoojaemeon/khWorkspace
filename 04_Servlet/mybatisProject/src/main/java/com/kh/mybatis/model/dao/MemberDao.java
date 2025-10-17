package com.kh.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;
import com.kh.mybatis.model.vo.Member;
import java.util.HashMap;

public class MemberDao {
	public Member loginMember(SqlSession sqlSession, String userId, String userPwd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("memberId", userId);
        map.put("memberPwd", userPwd);

        Member loginMember = sqlSession.selectOne("MemberMapper.loginMember", map);
        return loginMember;
    }
	
	public int idCheck(SqlSession sqlSession, String checkId) {
		return sqlSession.selectOne("MemberMapper.idCheck", checkId);
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("MemberMapper.insertMember", m);
	}
	
	public int updateMember(SqlSession sqlSession, Member m) {
		return sqlSession.update("MemberMapper.updateMember", m);
	}
	
	public Member selectMemberByUserId(SqlSession sqlSession, String userId) {       
        Member loginMember = sqlSession.selectOne("MemberMapper.selectMemberByUserId", userId);
        return loginMember;
	}
	
	public int updateMemberPwd(SqlSession sqlSession, String memberId, String updatePwd) {
		HashMap<String, String> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("updatePwd", updatePwd);
		
		return sqlSession.update("MemberMapper.updateMemberPwd", map);
	}
	
	public int deleteMember(SqlSession sqlSession, String userId) {
		return sqlSession.update("MemberMapper.deleteMember", userId);
	}
}















