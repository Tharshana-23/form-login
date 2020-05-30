package com.example.formlogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.formlogin.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authprovider=new DaoAuthenticationProvider();
		authprovider.setUserDetailsService(userDetailsService());
		authprovider.setPasswordEncoder(passwordEncoder());
		return authprovider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	
	
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http
			
			.authorizeRequests()
			.antMatchers("/superadmin").hasAnyAuthority("SUPERADMIN")
			.antMatchers("/admin").hasAnyAuthority("ADMIN","SUPERADMIN")
			.antMatchers("/login").permitAll()
			.antMatchers("/form").permitAll()
			.antMatchers("/update").permitAll()
			.anyRequest().authenticated()
			.and()
			.csrf()
			.disable()
			
			
			
			
			.formLogin().loginPage("/login")
			
			.defaultSuccessUrl("/admin")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
			
			
			
			

	}
}
