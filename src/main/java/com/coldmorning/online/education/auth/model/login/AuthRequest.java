package com.coldmorning.online.education.auth.model.login;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
	@NotEmpty(message = "username can not be empty")
	private String username;
	@NotEmpty(message = "password can not be empty")
	private String password;
}
