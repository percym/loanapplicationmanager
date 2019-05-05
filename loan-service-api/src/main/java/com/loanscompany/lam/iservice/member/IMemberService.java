package com.loanscompany.lam.iservice.member;

import com.loanscompany.lam.model.member.Member;

import java.util.List;

/**
 * The interface for the Membership service
 *
 * @author percym
 */
public interface IMemberService {

    Member save(Member member);

    void delete(Long memberId);

    Member findOne(Long memberId);

    List<Member> findAll();

    List<Member> findAllBySystemUser_Id(Long userId);

    List<Member> findAllByActive(Boolean active);

    List<Member> findAllBySystemUser_Location_Client_Id(Long clientId);
}
