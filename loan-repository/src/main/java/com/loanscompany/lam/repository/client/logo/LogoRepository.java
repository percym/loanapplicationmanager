package com.loanscompany.lam.repository.client.logo;

import com.loanscompany.lam.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * The repository interface for {@link Client} entity
 *
 * @author percym
 */
@Repository
public interface LogoRepository extends JpaRepository<Client,Long> , JpaSpecificationExecutor<Client>{

}
