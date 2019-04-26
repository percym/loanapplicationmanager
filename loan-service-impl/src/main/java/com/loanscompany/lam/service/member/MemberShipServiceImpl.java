package com.loanscompany.lam.service.member;

import com.loanscompany.lam.iservice.member.IMemberService;
import com.loanscompany.lam.model.member.Member;
import com.loanscompany.lam.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The implementation of the {@link IMemberService} interface
 *
 * @author percym
 */
@Service
@Transactional
public class MemberShipServiceImpl implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void delete(Long memberId) {
        memberRepository.deleteById(memberId);

    }

    @Override
    public Member findOne(Long memberId) {
        return memberRepository.getOne(memberId);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findAllBySystemUser_Id(Long userId) {
        return memberRepository.findAllBySystemUser_Id(userId);
    }

    @Override
    public List<Member> findAllByActive(Boolean active) {
        return memberRepository.findAllByActive(true);
    }
}
