package com.loanscompany.lam.endpoint.controller.location;

import com.codahale.metrics.annotation.Timed;

import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.location.ILocationService;
import com.loanscompany.lam.model.location.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Rest controller for managing locations
 *
 * @author Percy Mugadza
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class LocationController {

    private static final String ENTITY_NAME = "location";

    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }


    /**
     * GET  /location: get all the groups.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bill in body
     */
    @GetMapping("/location")
    @Timed
    public ResponseEntity<List<Location>> getAllLocation() {
        log.debug("REST request to get all IGroup");
        List<Location> locations = locationService.findAll();
        return new ResponseEntity<>(locations, null, HttpStatus.OK);
    }


    /**
     * GET  /location/:id : get the location by "id" .
     *
     * @param id the id of the location to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bill, or with status 404 (Not Found)
     */
    @GetMapping("/location/{id}")
    @Timed
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        log.debug("REST request to get IBill : {}", id);
        Location location = locationService.findOne(id);
        return ResponseEntity.ok(location);
    }
    /**
     * POST  /location: create location.
     *@param location  the permission to create
     * @return the ResponseEntity with status 200 (OK) and the updated permissions
     */
    @PostMapping("/location")
    @Timed
    public ResponseEntity<?> saveLocation(@Valid @RequestBody Location location) {
        log.debug("REST request to save location");
        if (location.getId()!= null){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid location id!"),
                    HttpStatus.BAD_REQUEST);
        }

        Location savedLocation = locationService.save(location);
        return new ResponseEntity<>(savedLocation, null, HttpStatus.OK);
    }

    /**
     * PUT  /location: update location.
     *@param location  the location to update
     * @return the ResponseEntity with status 200 (OK) and the updated group
     */
    @PutMapping("/location")
    @Timed
    public ResponseEntity<?> updateLocation(@Valid @RequestBody Location location) {
        log.debug("REST request to update");
        if (location.getId()== null){
            return new ResponseEntity<>(new ResponseMessage("Fail -> Invalid location information!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (location.getId()== 0){
            return new ResponseEntity<>(new ResponseMessage("Fail -> Invalid location information!"),
                    HttpStatus.BAD_REQUEST);
        }
       Location savedLocation= locationService.save(location);
        return new ResponseEntity<>(savedLocation, null, HttpStatus.OK);
    }

    /**
     * DELETE  /location/:id : delete the group by "id".
     *
     * @param id the id of the location to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/location/{id}")
    @Timed
    public ResponseEntity<?> deleteLocation(@PathVariable Long id) {
        log.debug("REST request to delete ILocation : {}", id);
        locationService.delete(id);
        return new ResponseEntity<>(new ResponseMessage("Done -> Item deleted!"),
                HttpStatus.OK);
    }


}