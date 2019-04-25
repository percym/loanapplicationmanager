package com.loanscompany.lam.endpoint.controller.auth;


import com.loanscompany.lam.endpoint.appconfig.security.jwt.JwtProvider;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.request.LoginForm;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.JwtResponse;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.user.ISystemUserService;
import com.loanscompany.lam.iservice.user.role.IRoleService;
import com.loanscompany.lam.model.user.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
    AuthenticationManager authenticationManager;


	final ISystemUserService userService;

	final IRoleService roleService;

	@Autowired
    PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	public AuthRestAPIs(ISystemUserService userService, IRoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, loginRequest.getUsername(),  userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SystemUser signUpRequest) {
		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		String encodedPass = encoder.encode(signUpRequest.getPassword());
		signUpRequest.setPassword(encodedPass);

		userService.save(signUpRequest);
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}