package com.coldmorning.online.education.auth.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "user")
public class User {

	@Column(name = "uuid")
	private String uuid;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;

	@Column(name = "is_delete")
	private String isDelete;

	public User(String uuid, String username, String password, String email) {
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User() {

	}
}
