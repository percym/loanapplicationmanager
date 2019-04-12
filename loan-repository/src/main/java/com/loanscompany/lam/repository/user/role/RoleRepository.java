package com.loanscompany.lam.repository.user.role;

import com.loanscompany.lam.model.user.Role;
import com.loanscompany.lam.utility.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * The repository for {@link Role}
 *
 * @author percym
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> ,JpaSpecificationExecutor<Role>{
   Optional<Role> findByName(RoleName roleName);
}
