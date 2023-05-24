package com.example.users.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
                .csrf(csrf -> csrf
                        .ignoringAntMatchers(
                                "/users/**"))
                .cors(withDefaults())
                .authorizeRequests(requests -> requests
                        .antMatchers(HttpMethod.GET
                        , "/users/**")
                        .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .antMatchers(HttpMethod.POST
                        , "/users/**")
                        .hasAuthority("ROLE_ADMIN")
                        .antMatchers(HttpMethod.PUT
                        , "/users/**")
                        .hasAuthority("ROLE_ADMIN")
                        .antMatchers(HttpMethod.DELETE
                        , "/users/**")
                        .hasAuthority("ROLE_ADMIN"))
                .formLogin(Customizer.withDefaults())
                .build();
				
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}