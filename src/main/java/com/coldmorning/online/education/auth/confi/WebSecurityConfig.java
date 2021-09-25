package com.coldmorning.online.education.auth.confi;

import com.coldmorning.online.education.auth.jwt.JWTConfigurer;
import com.coldmorning.online.education.auth.jwt.TokenProvider;
import com.coldmorning.online.education.auth.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;


    public WebSecurityConfig(
            TokenProvider tokenProvider
    ) {
        this.tokenProvider = tokenProvider;

    }


    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    @Override
    public void configure(WebSecurity http) {
        http.ignoring()
                // allow anonymous resource requests
                .antMatchers("/**/*.html")
                .antMatchers("/**/*.css")
                .antMatchers(    "/**/*.js")
                .antMatchers("/swagger-ui/index.html")
                .antMatchers("/test/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Disable spring-security login screen.
        http.httpBasic()
                .disable()
        //We don't need CSRF because our token is invulnerable
                .csrf().disable()
        // create no session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/api/v1/auth").permitAll()
                .antMatchers("/api/v1/auth/register").permitAll()
                .antMatchers("/api/v1/auth/**").authenticated()
                .antMatchers("/api/management/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                 .and()
                .apply(securityConfigurerAdapter());

    }


     public BCryptPasswordEncoder passwordEncoder() {
         BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
         return bCryptPasswordEncoder;
     }




    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider);
    }

}
