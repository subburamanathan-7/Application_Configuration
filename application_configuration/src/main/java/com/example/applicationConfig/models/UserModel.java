package com.example.applicationConfig.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Document(collection = "users")
public class UserModel implements UserDetails {
	
	@Id
    private String userId;
	private String username;
	private String password;
	private Set<RoleModel> authorities;
	
	
	public UserModel() {
		super();
		this.authorities = new HashSet<RoleModel>();
	}
	public UserModel(String username, String password, Set<RoleModel> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public String getUserId() {
		return this.userId;
	}
    public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
	public void setAuthorities(Set<RoleModel> authorities) {
		this.authorities = authorities;
	}
	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

	
}

