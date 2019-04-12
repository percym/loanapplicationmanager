package com.loanscompany.lam.repository.location;


import com.loanscompany.lam.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author percym
 *
 * <p>
 * Repository for {@link Location} location entity
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location> {
    
}