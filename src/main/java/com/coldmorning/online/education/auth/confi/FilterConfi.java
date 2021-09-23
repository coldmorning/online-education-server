package com.coldmorning.online.education.auth.confi;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coldmorning.online.education.auth.filter.JwtAuthFilter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class FilterConfi {
	
	@Bean
	public JwtAuthFilter JwtFilter() {
		return new JwtAuthFilter();
	}
	@Bean
	public FilterRegistrationBean logApiFilter() {
		FilterRegistrationBean<JwtAuthFilter> bean = new FilterRegistrationBean<>();
		bean.addUrlPatterns("/*");
		bean.setFilter(new JwtAuthFilter());
		bean.setName("JwtAuthorFilter");
		bean.setOrder(1);
		return bean;
		
	}
	
}
