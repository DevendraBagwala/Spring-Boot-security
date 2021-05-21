package com.divergentsl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;

	// Overriding User Detail Service

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	// Overriding password encoder

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
		//return new MD5Encoder();
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	// Authorization configuration
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// using basic authentication
		http.httpBasic();
		// All the request require authentication because anyRequest() is used
	 	http.authorizeRequests().anyRequest().authenticated();

		// Giving access to a particular url/resource to a use with particular authority
		// http.authorizeRequests().antMatchers("/student").hasAnyAuthority("read");
		
		// None of the requests need to be authenticated.
	    // http.authorizeRequests().anyRequest().permitAll();

	}

	// Authentication configuration

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * var userDetailsService = new InMemoryUserDetailsManager(); var user =
	 * User.withUsername("john").password("12345").authorities("read").build();
	 * userDetailsService.createUser(user);
	 * auth.userDetailsService(userDetailsService).passwordEncoder(
	 * NoOpPasswordEncoder.getInstance());
	 * 
	 * // auth.authenticationProvider(authenticationProvider); }
	 */

}
