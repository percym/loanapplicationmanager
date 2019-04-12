package com.loanscompany.lam.iservice.user;

import com.loanscompany.lam.model.user.SystemUser;

import java.util.List;
import java.util.Optional;

/**
 * The interface for the SystemUserService
 *
 * @author percym
 */
public interface ISystemUserService {

    SystemUser save(SystemUser systemUser);
    List<SystemUser> getSystemUserByActive(Boolean active);

    Optional<SystemUser> getSystemUserByUserName(String userName);

    Optional<SystemUser> getSystemUserByEmail(String email);

    List<SystemUser> findAllByLocation_Client_Id(Long clientId);

    List<SystemUser> findAll();

    Boolean existsByEmail(String email);
}
