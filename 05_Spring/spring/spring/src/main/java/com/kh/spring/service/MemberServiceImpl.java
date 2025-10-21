package com.kh.spring.service;

import com.kh.spring.model.mapper.MemberMapper;
import com.kh.spring.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service // @Component보다 더 구체화해서 service 객체에 알맞게 bean에 등록해준다.
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberMapper = memberMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Member getMemberById(String memberId) {
        return memberMapper.getMemberById(memberId);
    }

    @Override
    public int getMemberCountById(String memberId) {
        return memberMapper.getMemberCountById(memberId);
    }

    @Override
    public int addMember(Member member) {
        /*
            MyBatis를 spring 없이 단독으로 사용할 때에는 수동으로 커밋 혹은 롤백을 해줘야 한다.
            spring과 함께 사용할 때에는 트랜잭션처리를 스프링이 대신 해준다.
        */
        return memberMapper.addMember(member);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateMember(member);
    }

    @Override
    public int updatePwd(String memberId, String newPwd) {
        return memberMapper.updatePwd(memberId, newPwd);
    }

    @Override
    public int deleteMember(String memberId) {
        return memberMapper.deleteMember(memberId);
    }
}
