package com.monocept.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService (PasswordEncoder encoder){
		UserDetails admin= User.withUsername("Pranoy")
				.password(encoder.encode("admin"))
				.roles("admin")
				.build();
		UserDetails user= User.withUsername("Kaushik")
				.password(encoder.encode("user"))
				.roles("user")
				.build();
		return new InMemoryUserDetailsManager(admin,user);
		
	}
	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
//		       http.authorizeHttpRequests()
//		       .requestMatchers(HttpMethod.GET,"/userapp/**")
//				.hasRole("admin")
//				.requestMatchers(HttpMethod.POST,"/userapp/**")
//				.hasRole("admin")
//				.requestMatchers(HttpMethod.PUT,"/userapp/**")
//				.hasRole("admin")
//				.requestMatchers(HttpMethod.DELETE,"/userapp/**")
//				.hasRole("admin")
//				.requestMatchers("/contact/**")
//		        .hasRole("user")
//		        .requestMatchers("/contactdetails/**")
//		        .hasRole("user")
//		        .anyRequest()
//		        .authenticated()
//		        .and().formLogin().permitAll().and().logout().permitAll().and().httpBasic();
//		        http.cors().disable().csrf().disable();
//		        
//		        return http.build();
		http.authorizeHttpRequests((configurer) ->
		
		configurer.requestMatchers(HttpMethod.GET,"/userapp/**")
		.hasRole("admin")
		.requestMatchers(HttpMethod.POST,"/userapp/**")
		.hasRole("admin")
		.requestMatchers(HttpMethod.PUT,"/userapp/**")
		.hasRole("admin")
		.requestMatchers(HttpMethod.DELETE,"/userapp/**")
		.hasRole("admin")
		.requestMatchers("/contact/**")
        .hasRole("user")
        .requestMatchers("/contactdetails/**")
        .hasRole("user")
        
		);
		
		http.httpBasic();
		http.csrf().disable();
		
		return http.build();
		
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
