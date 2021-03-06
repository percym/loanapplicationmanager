package com.loanscompany.lam.endpoint.appconfig.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loanscompany.lam.imodel.user.ISystemUser;
import com.loanscompany.lam.model.user.Role;
import com.loanscompany.lam.model.user.SystemUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author percym
 */
public class UserPrinciple implements UserDetails {

    private static final long serialVersionUID = 2660731955835000992L;

    private Long id;

    private String name;

    private String username;

    private String email;

    private Boolean isActive;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    public UserPrinciple(Long id,String usernameAgain,
                         String username, String email, String password,Boolean isActive,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = usernameAgain;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.authorities = authorities;
    }

    public static UserPrinciple build(SystemUser user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getUserName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getActive(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
