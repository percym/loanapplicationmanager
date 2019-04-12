package com.loanscompany.lam.service.user.role;

import com.loanscompany.lam.iservice.user.role.IRoleService;
import com.loanscompany.lam.model.user.Role;
import com.loanscompany.lam.repository.user.role.RoleRepository;
import com.loanscompany.lam.utility.enums.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The implementation of {@link com.loanscompany.lam.iservice.user.role.IRoleService} interface
 *
 * @author percym
 */
@Service
@Transactional
public class IRoleServiceImpl  implements IRoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return Optional.empty();
    }
}
