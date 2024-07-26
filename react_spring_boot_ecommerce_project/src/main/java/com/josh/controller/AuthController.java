package com.josh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josh.config.JwtProvider;
import com.josh.exception.UserException;
import com.josh.model.User;
import com.josh.repository.UserRepository;
import com.josh.request.LoginRequest;
import com.josh.response.AuthResponse;
import com.josh.service.CustomerUserServiceImplimentation;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserRepository userRepository;

	private JwtProvider jwtprovider;

	private PasswordEncoder passwordEncoder;

	private CustomerUserServiceImplimentation customerUserService;

	public AuthController(UserRepository userRepository, CustomerUserServiceImplimentation customerUserService,
			PasswordEncoder passwordEncoder, JwtProvider jwtprovider) {
		this.userRepository = userRepository;
		this.customerUserService = customerUserService;
		this.passwordEncoder = passwordEncoder;
		this.jwtprovider = jwtprovider;
	}

	@PostMapping("/singup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();

		String lastName = user.getLastName();

		User isEmailExists = userRepository.findByEmail(email);

		if (isEmailExists != null) {
			throw new UserException("Email is already used with another account");
		}

		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);

		User savedUser = userRepository.save(createdUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
				savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtprovider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();

		authResponse.setJwt(token);
		authResponse.setMessage("Singup Success");

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);

	}

	@PostMapping("/singin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginrequest) {

		String username = loginrequest.getEmail();
		String password = loginrequest.getPassword();

		Authentication authentication = authenticate(username, password);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtprovider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();

		authResponse.setJwt(token);
		authResponse.setMessage("Singin Success");
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);

	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customerUserService.loadUserByUsername(username);

		if (userDetails == null) {
			throw new BadCredentialsException("Invalid UserName");
		}

		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid UserName");
		}

		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

	}

}
