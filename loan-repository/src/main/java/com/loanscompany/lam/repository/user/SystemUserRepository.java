package com.loanscompany.lam.repository.user;

import com.loanscompany.lam.model.user.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The repository for all {@link SystemUser}
 *
 * @author percym
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Long>,JpaSpecificationExecutor<SystemUser> {
    List<SystemUser>getSystemUserByActive(Boolean active);

    Optional<SystemUser> getSystemUserByUserName(String userName);

    Optional<SystemUser> getSystemUserByEmail(String email);

    List<SystemUser> findAllByLocation_Client_Id(Long clientId);

    List<SystemUser> findAll();

    Boolean existsByEmail(String email);
}
