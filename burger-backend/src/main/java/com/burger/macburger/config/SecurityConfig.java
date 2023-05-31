package com.burger.macburger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final CorsConfig corsConfig;
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
            .antMatchers("/user/**").authenticated()
            .antMatchers("/manager/**").hasAuthority("MANAGER")
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .anyRequest().permitAll()
            
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            
            .and()
            
            .formLogin().disable()
            .httpBasic().disable()
            
            .apply(new MYCustomDsl())
            
            .and()
            .formLogin()
            .loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
            
            .and()
            .oauth2Login()
            .loginPage(".loginForm")
            .defaultSuccessUrl("/")
            .userInfoEndpoint()
//            .userService(null)
            ;
            
		return http.build();
	}
	
	public class MYCustomDsl extends AbstractHttpConfigurer<MYCustomDsl, HttpSecurity> {
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
			http.addFilter(corsConfig.corsFilter());
		}
	}
	
}


//@Bean
//SecurityFilterChain filter(HttpSecurity http) throws Exception {
//	return http.csrf().disable()
//			.authorizeRequests(authrize -> authrize.antMatchers("/api/v1/user/**")
//					.access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//					
//					.antMatchers("/api/v1/manager/**")
//					.access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//					
//					.antMatchers("/api/v1/admin/**")
//					.access("hasRole('ROLE_ADMIN')")
//					
//					.anyRequest().permitAll())
//			
//			
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			
//			.and()
//			
//			
//			.formLogin().disable()
//			.httpBasic().disable()
//			
//			.apply(new MYCustomDsl())
//			
//			.and()
//			.formLogin()
//			.loginPage("/loginForm")
//			.loginProcessingUrl("/login")
//			.defaultSuccessUrl("/")
//			
//			.and()
//			.oauth2Login()
//			.loginPage("/loginForm")
//			.defaultSuccessUrl("/")
//			.userInfoEndpoint();
//			
//			
//}
