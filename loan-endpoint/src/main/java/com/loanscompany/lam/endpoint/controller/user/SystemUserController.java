package com.loanscompany.lam.endpoint.controller.user;

import com.codahale.metrics.annotation.Timed;
import com.loanscompany.lam.iservice.user.ISystemUserService;
import com.loanscompany.lam.model.user.Role;
import com.loanscompany.lam.model.user.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller for system users
 *
 * @author percym
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class SystemUserController {

    private final ISystemUserService systemUserService;

    public SystemUserController(ISystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    /**
     * GET  /systems_users: get all the role.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of system users in body
     */
    @GetMapping("/systems_users")
    @Timed
    public ResponseEntity<List<SystemUser>> getAllUsers() {
        log.debug("REST request to get all IGroup");
        List<SystemUser> systemUsers = systemUserService.findAll();
        return new ResponseEntity<>(systemUsers, null, HttpStatus.OK);
    }
}
