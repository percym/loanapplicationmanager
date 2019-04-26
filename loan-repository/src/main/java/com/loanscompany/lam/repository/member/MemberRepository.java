package com.loanscompany.lam.repository.member;

import com.loanscompany.lam.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the {@link Member } entity
 *
 * @author percym
 */
@Repository
public interface MemberRepository  extends JpaRepository<Member, Long>{
    List<Member> findAllBySystemUser_Id(Long userId);

    List<Member> findAllByActive(Boolean active);

}
