package com.coldmorning.online.education.auth.service.impl;

import com.coldmorning.online.education.auth.model.User;
import com.coldmorning.online.education.auth.repository.AuthRepository;

import com.coldmorning.online.education.auth.util.response.ResultCode;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AuthRepository authRepository;

    private static final String className = UserDetailsServiceImpl.class.getName();

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        Optional<User> user = authRepository.findByEmail(email);

        if (user.isPresent()) {
            log.info(String.format("[%s.loadUserByUsername]: %s",className,"User email is correct."));
            return user.get();
        } else {
            log.info(String.format("[%s.loadUserByUsername]: %s",className,"User email is wrong."));
            throw new UsernameNotFoundException("User email is wrong.");
        }
    }



}
