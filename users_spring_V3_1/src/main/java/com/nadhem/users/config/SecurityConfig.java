package com.nadhem.users.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	JWTAuthorizationFilter authorizationFilter;
	
	@Autowired
	AuthenticationProvider authenticationProvider;
	
	

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/allUsers").hasAuthority("ADMIN")
                        .requestMatchers("/login").permitAll())
                .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
              
        return http.build();
    }
    
	


}
