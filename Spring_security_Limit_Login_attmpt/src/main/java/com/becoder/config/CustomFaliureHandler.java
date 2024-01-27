package com.becoder.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.becoder.entity.User;
import com.becoder.repository.UserRepo;
import com.becoder.service.UserService;
import com.becoder.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class CustomFaliureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String email = request.getParameter("username");
	User user = userRepo.findByEmail(email);

		if (user != null) {

			if (user.isEnable()) {

				if (user.isAccountNotLocked()) {
					if (user.getFailedAttempt() < UserServiceImpl.attemp_Time - 1) {
						userService.increasedFailedAttempt(user);

					} else {
						userService.lock(user);
						exception = new LockedException("Account is locked !!!!!!!!!!!!!!!!!");
					}
				} else if (!user.isAccountNotLocked()) {
					if (userService.unLockedAccountTimeExpired(user)) {
						exception = new LockedException("Account is unlocked please try to login");
					} else {
						exception = new LockedException("Account is locked please try after some time");
					}

				}

			} else {

				exception = new LockedException("Account is inactived verified account");
			}

		}

		super.setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}

}
