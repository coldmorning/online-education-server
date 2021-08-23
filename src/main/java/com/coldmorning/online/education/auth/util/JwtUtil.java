package com.coldmorning.online.education.auth.util;

import java.io.Serializable;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtil   implements Serializable {

	private static final long EXPIRE_AT_TIME = 4* 60 * 60 *1000;
	
    public static String  sign(String username,String secret)  throws JWTCreationException {
    
    	Date date = new Date (System.currentTimeMillis() + EXPIRE_AT_TIME);
        Algorithm algorithm = Algorithm.HMAC512(secret);
        return JWT.create()
        		.withIssuer("coldmorningWebAPI")
        		.withClaim("username", username)
        		.withExpiresAt(date)
        		.sign(algorithm);
       
    }
    
    public static Boolean verify(String token,String secret) throws JWTDecodeException {
       Algorithm algorithm = Algorithm.HMAC512(secret);
       JWTVerifier verifier = JWT.require(algorithm)
               .build();
       DecodedJWT jwt = verifier.verify(token);
        return true;
    }
    
    public static String getUsername(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("username").asString();
    }
}
