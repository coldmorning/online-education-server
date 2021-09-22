package com.coldmorning.online.education.auth.service;

import com.coldmorning.online.education.auth.model.request.AuthRegisterRequest;
import com.coldmorning.online.education.auth.util.response.ResultResponse;
import org.springframework.stereotype.Service;


public interface AuthService {
    public ResultResponse Resgister(AuthRegisterRequest request);
}
