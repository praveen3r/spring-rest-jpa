package com.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.util.Constants;

public class AuthenticationFilter extends OncePerRequestFilter {

	
	String secretKey;
	
	
	public AuthenticationFilter(String secretKey) {
		this.secretKey = secretKey;
	}


	protected void doFilterInternal(
        HttpServletRequest request, 
        HttpServletResponse response, 
        FilterChain filterChain) throws ServletException, IOException {
    
    	final HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = null;
		String jwtToken = null;
		if (httpRequest.getHeader(Constants.AUTH_HEADER) != null) {
			token = httpRequest.getHeader(Constants.AUTH_HEADER);
			jwtToken = token.replaceAll(Constants.BEARER_VAL, "");
		} 
		
		SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
		securityContext = new SecurityContextImpl();
		if (StringUtils.isNotEmpty(token)) {
			if (StringUtils.isNotEmpty(jwtToken)) {
				
				//jwt processing logic
				
				final UsernamePasswordAuthenticationToken upt = new UsernamePasswordAuthenticationToken("", "", null);
				upt.setDetails("Extra details");
				securityContext.setAuthentication(upt);
					
			} 
		}
		
		try {
			SecurityContextHolder.setContext(securityContext);
			filterChain.doFilter(request, response);
		} finally {
			// Clear the context and free the thread local
			SecurityContextHolder.clearContext();
		}
    
    }
}