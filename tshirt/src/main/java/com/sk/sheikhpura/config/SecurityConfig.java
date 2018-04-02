package com.sk.sheikhpura.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
		return manager;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sohag").password("123456").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/prod").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/product").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/product").permitAll()
				.antMatchers("/product_details").permitAll()
				.antMatchers("/add_to_cart").permitAll()
				.antMatchers("/addToCart").permitAll()
				.antMatchers("/admin/userList").permitAll()
				.and().formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/product")
				.failureUrl("/login?error")
				.and()
				.logout()
				.logoutSuccessUrl("/login?logout");
				http.csrf().disable();
	}
}
