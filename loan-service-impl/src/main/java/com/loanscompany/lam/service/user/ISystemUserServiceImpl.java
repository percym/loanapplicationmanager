package com.loanscompany.lam.service.user;

import com.loanscompany.lam.iservice.user.ISystemUserService;
import com.loanscompany.lam.model.user.SystemUser;
import com.loanscompany.lam.repository.user.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The implementation {@link ISystemUserService} service
 *
 * @author percym
 */
@Transactional
@Service
public class ISystemUserServiceImpl  implements ISystemUserService {

    @Autowired
    SystemUserRepository systemUserRepository;


    @Override
    public SystemUser save(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    public List<SystemUser> getSystemUserByActive(Boolean active) {
        return systemUserRepository.getSystemUserByActive(active);
    }

    public Optional<SystemUser> getSystemUserByUserName(String userName) {
        return systemUserRepository.getSystemUserByUserName(userName);
    }

    public Optional<SystemUser> getSystemUserByEmail(String email) {
        return systemUserRepository.getSystemUserByEmail(email);
    }


    public List<SystemUser> findAllByLocation_Client_Id(Long clientId) {
        return systemUserRepository.findAllByLocation_Client_Id(clientId);
    }

    public List<SystemUser> findAll() {
        return systemUserRepository.findAll();
    }

    public Boolean existsByEmail(String email) {
        return systemUserRepository.existsByEmail(email);
    }
}
