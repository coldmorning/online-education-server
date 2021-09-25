package com.coldmorning.online.education.auth.service.impl;

import com.coldmorning.online.education.auth.model.User;
import com.coldmorning.online.education.auth.model.request.AuthRegisterRequest;
import com.coldmorning.online.education.auth.repository.AuthRepository;
import com.coldmorning.online.education.auth.util.AuthUtil;
import com.coldmorning.online.education.auth.util.UUIDType5;
import com.coldmorning.online.education.auth.util.response.ResultCode;
import com.coldmorning.online.education.auth.util.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.coldmorning.online.education.auth.service.AuthService;

import java.util.*;

@Slf4j
@Service
public class AuthServiceImpl implements  AuthService  {
    @Autowired
    AuthRepository authRepository;

    private static final String className = AuthServiceImpl.class.getName();


    @Override
    public ResultResponse Resgister(AuthRegisterRequest request) {
        String repeatPassword = request.getSecondPassword();
        if (request.getPassword().equals(repeatPassword) == false) {
            log.info(String.format("[%s.Resgister]: %s",className,ResultCode.ERROR_Register_RePassword.msg));
            return new ResultResponse(ResultCode.ERROR_Register_RePassword);
        }
        Optional<User> findUserEmail = authRepository.findByEmail(request.getEmail());
        if(findUserEmail!=null){
            log.info(String.format("[%s.Resgister]: %s",className,ResultCode.ERROR_Register_Exist.msg));
            return new ResultResponse(ResultCode.ERROR_Register_Exist);
        }
        UUID createUuid = UUIDType5.nameUUIDFromNamespaceAndString(UUIDType5.NAMESPACE_URL, UUIDType5.coldmorningURL);
        String bcryptPassword = AuthUtil.BCryptPassword(request.getPassword());
        User createUser = new User(createUuid.toString(),request.getName(),bcryptPassword,request.getEmail());
        User newUser = authRepository.save(createUser);

        if (newUser==null) {
             log.info(String.format("[%s.Resgister]: %s",className,ResultCode.ERROR_Register_Other.msg));
            return new ResultResponse(ResultCode.ERROR_Register_Other);
        }

        log.info(String.format("[%s.Resgister]: %s",className,ResultCode.SUCESS_Register.msg));
         return new ResultResponse(ResultCode.SUCESS_Register);
    }


}
