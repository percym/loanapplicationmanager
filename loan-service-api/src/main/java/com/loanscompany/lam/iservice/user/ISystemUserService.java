package com.loanscompany.lam.iservice.user;

import com.loanscompany.lam.model.user.SystemUser;

import java.util.List;

/**
 * The interface for the SystemUserService
 *
 * @author percym
 */
public interface ISystemUserService {
    List<SystemUser> getSystemUserByActive(Boolean active);

    SystemUser getSystemUserByUserName(String userName);

    SystemUser getSystemUserByEmail(String email);

    List<SystemUser> findAllByLocation_Client_Id(Long clientId);

    List<SystemUser> findAll();
}
