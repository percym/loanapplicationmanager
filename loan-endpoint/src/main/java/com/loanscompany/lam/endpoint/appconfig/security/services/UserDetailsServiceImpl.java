package com.loanscompany.lam.endpoint.appconfig.security.services;

import com.loanscompany.lam.model.user.SystemUser;
import com.loanscompany.lam.repository.user.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author percym
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SystemUser user = systemUserRepository.getSystemUserByEmail(s).orElseThrow(
                ()-> new UsernameNotFoundException("User Not Found with -> username  : " + s)
        );

        return UserPrinciple.build(user);
    }
}
