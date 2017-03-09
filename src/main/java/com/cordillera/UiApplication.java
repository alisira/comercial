package com.cordillera;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UiApplication {

	 @Autowired 
	 private UserDetailsService userDetailsService;
	

	
	@RequestMapping("/user")
	public Principal user(Principal user) {		
		//System.out.println("user:" + user.getName());		
		//System.out.println("user2:" + user.toString());
		return user;
	}

	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
				.httpBasic().and()
				.authorizeRequests()
					.antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
					.anyRequest().authenticated()
					.and()
				.csrf()
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
			// @formatter:on
			// @formatter:on
		}
	}
	
	@RequestMapping("/token")
	public Map<String,String> token(HttpSession session, Principal user) {
		//System.out.println("token:" + session.getId());
		//System.out.println(session.getAttributeNames());
		
		
		System.out.println("user en token:" + user.toString());
		
		
		
		System.out.println(Collections.singletonMap("token", session.getId()));
		
		return Collections.singletonMap("token", session.getId());
	}
	
	

	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		 
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	 } 
	 
	
	
	 @Bean(name="passwordEncoder")
	 public PasswordEncoder passwordencoder(){
		 return new BCryptPasswordEncoder();
	 }
	
	
	
}
