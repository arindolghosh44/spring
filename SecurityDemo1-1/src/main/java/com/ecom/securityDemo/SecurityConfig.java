package com.ecom.securityDemo;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaSecurityFilterChain(HttpSecurity http)throws Exception{
		
		http.authorizeHttpRequests((requests)->requests.anyRequest().authenticated());
		//stateless cookies not created
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
