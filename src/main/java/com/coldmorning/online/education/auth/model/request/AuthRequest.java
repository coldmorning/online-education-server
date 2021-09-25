package com.coldmorning.online.education.auth.model.request;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
	@NotEmpty(message = "email can not be empty")
	private String email;
	@NotEmpty(message = "password can not be empty")
	private String password;
}
