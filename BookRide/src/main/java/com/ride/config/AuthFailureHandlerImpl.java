package com.ride.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.ride.model.UserDtls;
import com.ride.repository.UserRepository;
import com.ride.service.UserService;
import com.ride.util.AppConstant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler{
	

    @Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String email = request.getParameter("username");//here we use username instead of email

		UserDtls userDtls = userRepository.findByEmail(email);
		
		
		
		if (userDtls != null) {

		if (userDtls.getIsEnable()) {

			if (userDtls.getAccountNonLocked()) {

				if (userDtls.getFailedAttempt() < AppConstant.ATTEMPT_TIME) {
					userService.increaseFailedAttempt(userDtls);
				} else {
					userService.userAccountLock(userDtls);
					exception = new LockedException("Your account is locked !! failed attempt 3");
				}
			} else {

				if (userService.unlockAccountTimeExpired(userDtls)) {
					exception = new LockedException("Your account is unlocked !! Please try to login");
				} else {
					exception = new LockedException("your account is Locked !! Please try after sometimes");
				}
			}

		} else {
			exception = new LockedException("your account is inactive");
		}
		
		}else {
			
			exception = new LockedException("Email & password invalid");
		}
		
		super.setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}
	
	
	
	
	
	

}
