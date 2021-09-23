package com.coldmorning.online.education.auth.confi;

import com.coldmorning.online.education.auth.filter.JwtAuthFilter;
import com.coldmorning.online.education.auth.service.AuthService;
import com.coldmorning.online.education.auth.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    private AuthService authService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Disable spring-security login screen.
        http.httpBasic().disable();
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api/v1/auth/**").permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    }


     public BCryptPasswordEncoder passwordEncoder() {
         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
         return bCryptPasswordEncoder;
     }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
    }



}
