package com.coldmorning.online.education.auth.controller;

import javax.validation.Valid;

import com.coldmorning.online.education.auth.model.request.AuthRegisterRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coldmorning.online.education.auth.model.request.AuthRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value ="/api/v1/auth")
public class JwtAuthController {
	



    @PostMapping(value = "")
    public ResponseEntity<?> auth(@Valid @RequestBody AuthRequest request){
       log.info("auth");

       return ResponseEntity.ok("");
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRegisterRequest request){
        log.info("create");

        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(){
       log.info("auth");
       return  ResponseEntity.ok("Test");
    }
}
