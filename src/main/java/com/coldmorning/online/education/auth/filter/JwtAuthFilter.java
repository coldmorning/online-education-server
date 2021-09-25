package com.coldmorning.online.education.auth.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coldmorning.online.education.auth.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;


@Slf4j

public class JwtAuthFilter extends OncePerRequestFilter {

	private TokenProvider tokenProvider;

	public JwtAuthFilter(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

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
			if(tokenProvider.validateToken(token) ){

				chain.doFilter(request, response);
		 	}else
		 	{
				chain.doFilter(request, response);
				//response.setStatus(HttpStatus.UNAUTHORIZED.value());
				//PrintWriter out = response.getWriter();
			//	response.setContentType("application/json");
				//response.setCharacterEncoding("UTF-8");
				//out.print("token is invalid");
				//out.flush();
			}

	}
}
