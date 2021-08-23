package com.coldmorning.online.education.auth.confi;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coldmorning.online.education.auth.filter.JwtAuthorFilter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class FilterConfi {
	
	@Bean
	public JwtAuthorFilter JwtFilter() {
		return new JwtAuthorFilter();
	}
	@Bean
	public FilterRegistrationBean logApiFilter() {
		FilterRegistrationBean<JwtAuthorFilter> bean = new FilterRegistrationBean<>();
		bean.addUrlPatterns("/*");
		bean.setFilter(new JwtAuthorFilter());
		bean.setName("JwtAuthorFilter");
		bean.setOrder(1);
		return bean;
		
	}
	
}
