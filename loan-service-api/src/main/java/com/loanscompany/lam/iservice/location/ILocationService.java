package com.loanscompany.lam.iservice.location;


import com.loanscompany.lam.model.location.Location;

import java.util.List;

public interface ILocationService {

    Location save(Location location);

    void delete(Long locationId);

    Location findOne(Long locationId);

    List<Location> findAll();
}
