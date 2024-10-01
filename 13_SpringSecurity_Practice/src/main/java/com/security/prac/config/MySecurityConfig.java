package com.security.prac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		org.springframework.security.config.Customizer<CsrfConfigurer<HttpSecurity>> customizer = new org.springframework.security.config.Customizer<CsrfConfigurer<HttpSecurity>>() {

			@Override
			public void customize(CsrfConfigurer<HttpSecurity> cust) {
				cust.disable();

			}
		};
		httpSecurity.csrf(customizer);// disable csrf token
		// Now of doing all this, we can use lambda expression because they are
		// functional interface
		httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		httpSecurity.formLogin(org.springframework.security.config.Customizer.withDefaults()); // enable login form
		httpSecurity.httpBasic(org.springframework.security.config.Customizer.withDefaults()); // // enable credentials
																								// from REST APIs
		return httpSecurity.build();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder());// this is decrypt the password than match
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
}
