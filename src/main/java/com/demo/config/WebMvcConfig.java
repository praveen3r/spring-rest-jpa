package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.demo.interceptor.DemoInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new DemoInterceptor());
	}
	
}
