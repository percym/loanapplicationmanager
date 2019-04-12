package com.loanscompany.lam.iservice.user.role;

import com.loanscompany.lam.model.user.Role;
import com.loanscompany.lam.utility.enums.RoleName;

import java.util.List;
import java.util.Optional;

/**
 * The repository interface for {@link Role} role entity
 *
 * @author percym
 */
public interface IRoleService {
    Role save(Role role);

    List<Role> findAll();

    Optional<Role> findByName(RoleName roleName);
}
