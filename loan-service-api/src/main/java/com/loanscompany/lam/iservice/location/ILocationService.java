package com.loanscompany.lam.iservice.location;


import com.loanscompany.lam.model.location.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ILocationService {

    Location save(Location location);

    void delete(Long locationId);

    Location findOne(Long locationId);

    List<Location> findAll();
}
