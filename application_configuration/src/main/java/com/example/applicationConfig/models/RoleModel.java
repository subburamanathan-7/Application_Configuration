package com.example.applicationConfig.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document(collection = "roles")
public class RoleModel implements GrantedAuthority {
	
	@Id
    private String roleId;
	
	private String authority;
	

	public String getRoleId() {
		return roleId;
	}

	public RoleModel(String authority) {
		super();
		this.authority = authority;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
}

