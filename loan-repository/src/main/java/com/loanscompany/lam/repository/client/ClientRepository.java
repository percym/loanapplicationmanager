package com.loanscompany.lam.repository.client;

import com.loanscompany.lam.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *  The interface for the {@link Client} client entity
 *
 * @author percym
 */
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client> {
    Client findFirstByRegNumber(String regNumber);
}
