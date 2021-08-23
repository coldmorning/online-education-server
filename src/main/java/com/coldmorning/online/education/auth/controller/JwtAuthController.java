package com.coldmorning.online.education.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coldmorning.online.education.auth.model.login.AuthRequest;
import com.coldmorning.online.education.auth.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value ="/api/v1/auth")
public class JwtAuthController {
	
	@Value("${jwt.secret}")
	private String secret;

    @PostMapping
    public ResponseEntity<?> auth(@Valid @RequestBody AuthRequest request){
       log.info("auth");
       String jwt = JwtUtil.sign(request.getUsername(),secret);
       return ResponseEntity.ok(jwt);
    }
    
    @GetMapping(value = "/test")
    public ResponseEntity<?> test(){
       log.info("auth");
       return  ResponseEntity.ok("Test");
    }
}
