package com.loanscompany.lam.iservice.client;


import com.loanscompany.lam.model.client.Client;

import java.util.List;

/**
 * Interface for Client entity
 *
 * @author percym
 */
public interface IClientService {

    /**
     * Save an client.
     *
     * @param client the entity to save
     * @return the persisted entity
     */
    Client save(Client client);

    /**
     * Get all the client.
     *
     * @return the list of entities
     */
    List<Client> findAll();

    /**
     * Get the "id" client.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Client findOne(Long id);

    /**
     * Delete the "id" client.
     *
     * @param id the id of the entity
     */
    void delete(Long id);


    /**
     * Get the first record in client table.
     *
     * @param regNumber the client database being used in the current Context.
     * @return the entity
     */
    Client findFirstByRegNumber(String regNumber);


}
