package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity // this enable @PreAuthorize
@EnableWebSecurity
public class MySecurityConfig {
	@Autowired
	public UserDetailsService userDetailsService;

//	 Encrypt password
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails normalUser = User.withUsername("normal").password(passwordEncoder().encode("normal"))
//				.roles("NORMAL").build();
//		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
//				.build();
//
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(normalUser, admin);
//		return manager;
//
//	}

	// Below method is working but deprecated
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable().authorizeRequests().requestMatchers("/users/normal").hasRole("NORMAL")
//				.requestMatchers("/users").hasRole("ADMIN").requestMatchers("/users/public").permitAll().anyRequest()
//				.authenticated().and().formLogin();
//		return httpSecurity.build();
//	}
	// So we use this now
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
	// Connecting to database to fetch UserName & Password
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

}
