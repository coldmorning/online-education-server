package com.coldmorning.online.education.auth.model.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AuthRegisterRequest {

    @NotEmpty(message = "name can not be empty")
    private String name;
    @NotEmpty(message = "email can not be empty")
    private String email;
    @NotEmpty(message = "password can not be empty")
    private String password;
    @NotEmpty(message = "secondPassword can not be empty")
    private String secondPassword;


}
