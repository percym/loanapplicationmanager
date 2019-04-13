package com.loanscompany.lam.service.location;

import com.loanscompany.lam.iservice.location.ILocationService;
import com.loanscompany.lam.model.location.Location;
import com.loanscompany.lam.repository.location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Service implementation for ILocationService
 *
 * @author Percy Mugadza
 */
@Service
@Transactional
public class ILocationServiceImpl implements ILocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public Location findOne(Long locationId) {
        return locationRepository.getOne(locationId);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

}
