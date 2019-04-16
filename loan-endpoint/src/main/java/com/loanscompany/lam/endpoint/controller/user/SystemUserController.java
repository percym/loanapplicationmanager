package com.loanscompany.lam.endpoint.controller.user;

import com.codahale.metrics.annotation.Timed;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.user.ISystemUserService;
import com.loanscompany.lam.model.user.Role;
import com.loanscompany.lam.model.user.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    ISystemUserService userService;

    @Autowired
    PasswordEncoder encoder;

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


    /**
     * PUT  /systems_user:update system user controller
     *
     * @return the ResponseEntity with status 200 (OK) and message depending on result
     */
    @PutMapping("/systems_user")
    @Timed
    public ResponseEntity<?> updateUser(@Valid @RequestBody SystemUser updateUser) {
        log.debug("REST request to get all IGroup");
        if (!(userService.existsByEmail(updateUser.getEmail()))) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username does not exist"),
                    HttpStatus.BAD_REQUEST);
        }

        if (updateUser.getId() == 0) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> invalid user id"),
                    HttpStatus.BAD_REQUEST);
        }

        if (updateUser.getId() == null) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> invalid user id"),
                    HttpStatus.BAD_REQUEST);
        }
        String encodedPass = encoder.encode(updateUser.getPassword());
        updateUser.setPassword(encodedPass);

        userService.save(updateUser);
        return new ResponseEntity<>(new ResponseMessage("User updated successfully!"), HttpStatus.OK);

    }
}
