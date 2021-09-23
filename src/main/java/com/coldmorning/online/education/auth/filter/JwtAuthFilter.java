package com.coldmorning.online.education.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import com.coldmorning.online.education.auth.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;


@Slf4j
@WebFilter(filterName = "JwtAuthorFilter", urlPatterns = "/api/*")
public class JwtAuthFilter extends OncePerRequestFilter {
	
	@Value("${jwt.secret}")
	private String secret;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		checkJWTByRequest(request, response, chain);

	}

	 private void checkJWTByRequest(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException	 {
		 	log.info(request.getRequestURL().toString());
			String bearerToken = request.getHeader("Authorization");
			String token = ""; 
			if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
				log.info(bearerToken.substring(7, bearerToken.length()));
				token = bearerToken.substring(7, bearerToken.length());
			}
			try {
				JwtUtil.verify(token, secret);

			}catch(Exception ex){
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
			}
	}
}
