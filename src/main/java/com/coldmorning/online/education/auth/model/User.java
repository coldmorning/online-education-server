package com.coldmorning.online.education.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails {
	@Id
	@Column(name = "uuid")
	private String uuid;
	@Column(name = "username")
	private String username;
	@JsonIgnore
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;

	@Column(name = "delete_time")
	private Date deleteTime;
	@Column(name = "update_time")
	private Date updateTime;
	@Column(name = "create_time")
	private String createTime;

	@Column(name = "delete_by")
	private Date deleteBy;
	@Column(name = "createBy")
	private String createBy;
	@Column(name = "updateBy")
	private String updateBy;

	public User(String uuid, String username, String password, String email) {
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		return grantList;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
