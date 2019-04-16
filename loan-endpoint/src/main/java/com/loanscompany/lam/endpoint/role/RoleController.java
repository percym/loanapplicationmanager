package com.loanscompany.lam.endpoint.role;

import com.codahale.metrics.annotation.Timed;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.user.role.IRoleService;
import com.loanscompany.lam.model.location.Location;
import com.loanscompany.lam.model.user.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest controller for managing roles
 *
 * @author Percy Mugadza
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class RoleController {

    private  final IRoleService roleService;


    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * GET  /role: get all the role.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of roles in body
     */
    @GetMapping("/role")
    @Timed
    public ResponseEntity<List<Role>> getAllRole() {
        log.debug("REST request to get all IGroup");
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<>(roles, null, HttpStatus.OK);
    }

    /**
     * POST  /role: create role.
     *@param role  the role to create
     * @return the ResponseEntity with status 200 (OK) and the updated role
     */
    @PostMapping("/role")
    @Timed
    public ResponseEntity<?> saveRole(@Valid @RequestBody Role role) {
        log.debug("REST request to save role");
        if (role.getId()!= null){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->invalid role id!"),
                    HttpStatus.BAD_REQUEST);
        }

        Role savedRole = roleService.save(role);
        return new ResponseEntity<>(savedRole, null, HttpStatus.OK);
    }


    /**
     * PUT  /role: update role.
     *@param role  the role to update
     * @return the ResponseEntity with status 200 (OK) and the updated role
     */
    @PutMapping("/role")
    @Timed
    public ResponseEntity<?> updateRole(@Valid @RequestBody Role role) {
        log.debug("REST request to save role");
        if (role.getId()== null){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->invalid role id!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (role.getId()== 0){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->invalid role id!"),
                    HttpStatus.BAD_REQUEST);
        }

        Role savedRole = roleService.save(role);
        return new ResponseEntity<>(savedRole, null, HttpStatus.OK);
    }
}
