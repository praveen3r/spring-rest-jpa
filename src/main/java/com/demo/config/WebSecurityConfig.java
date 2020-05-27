package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.demo.filter.AuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Value("${token.secretKey}")
	private String secretKey;

	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers("/webjars/**")
        .antMatchers("/swagger-ui.html")
        .antMatchers("/v2/**")
        .antMatchers("/swagger-resources/**");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.addFilterBefore(new AuthenticationFilter(secretKey), LogoutFilter.class)
		.authorizeRequests()
		.anyRequest().authenticated();
	}
	
}
