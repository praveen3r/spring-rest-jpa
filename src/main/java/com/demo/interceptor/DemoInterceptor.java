package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		Boolean isValid = true;
		String jwtValue = request.getHeader("Authorization");
        if(jwtValue!=null && jwtValue.equals("test")) {
        	response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        	isValid = false;
        }
     
        return isValid;
    }

	
}
