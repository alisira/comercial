package com.comercial;

import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.resteasy.plugins.server.servlet.FilterDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.comercial.storage.StorageProperties;
import com.comercial.storage.StorageService;

//@EnableJpaRepositories
@SpringBootApplication
@RestController
@EnableConfigurationProperties(StorageProperties.class)
public class UiApplication {

	 @Autowired 
	 private UserDetailsService userDetailsService;

	 @RequestMapping("/resource")
	 public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	 }

	 public static void main(String[] args) {

		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("FL_PU");		 
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
			 .antMatchers("/", "/user", "/error", "/index.html", "/html/home.html", "/html/login.html", "/html/navigation.html", "/bootstrap/*/*", "/token"  ).permitAll()
			 .anyRequest().authenticated()
			 .and()
			 .csrf()
			 .csrfTokenRepository(csrfTokenRepository())
			 .and()
			 .addFilterAfter(csrfHeaderFilter(), SessionManagementFilter.class);
			 ;
			 // @formatter:on
			 // @formatter:on
		 }
	 }	

	 private static Filter csrfHeaderFilter() {
		 return new OncePerRequestFilter() {

			 @Override
			 protected void doFilterInternal(HttpServletRequest request,
					 HttpServletResponse response,
					 FilterChain filterChain) throws ServletException, IOException {

				 CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
				 if (csrf != null) {
					 Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
					 String token = csrf.getToken();
					 if (cookie == null || token != null
							 && !token.equals(cookie.getValue())) {

						 // Token is being added to the XSRF-TOKEN cookie.
						 cookie = new Cookie("XSRF-TOKEN", token);
						 cookie.setPath("/");
						 response.addCookie(cookie);
					 }
				 }
				 filterChain.doFilter(request, response);
			 }
		 };
	 }

	 private static CsrfTokenRepository csrfTokenRepository() {
		 HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		 repository.setHeaderName("X-XSRF-TOKEN");
		 return repository;
	 }

	 @RequestMapping("/token")
	 public Map<String,String> token(HttpSession session, Principal user) {
		 System.out.println("token:" + session.getId());
		 //System.out.println(session.getAttributeNames());
		 //System.out.println("user en token:" + user.toString());
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

	 @Bean
	 CommandLineRunner initialize(StorageService storageService) {
		 return (args) -> {            
			 storageService.init();
		 };
	 }

}
