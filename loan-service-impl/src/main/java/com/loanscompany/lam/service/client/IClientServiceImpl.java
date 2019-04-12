package com.loanscompany.lam.service.client;

import com.loanscompany.lam.iservice.client.IClientService;
import com.loanscompany.lam.model.client.Client;
import com.loanscompany.lam.repository.client.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service implementation for Client entity
 *
 * @author Munyaradzi Takayindisa
 */
@Slf4j
@Service
@Transactional
public class IClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;


    /**
     * Save a client.
     *
     * @param client the entity to save
     * @return the persisted entity
     */
    @Override
    public Client save(Client client) {
        log.debug("Request to save Clients : {}", client);
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    /**
     * Get one client by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Client findOne(Long id) {
        log.debug("Request to get Clients : {}", id);
        return clientRepository.getOne(id);
    }

    /**
     * Delete the client by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Clients : {}", id);
        clientRepository.deleteById(id);
    }

    @Override
    public Client findFirstByRegNumber(String regNumber) {
        return clientRepository.findFirstByRegNumber(regNumber);
    }
}