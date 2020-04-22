package com.ry.dto;

import com.ry.pojo.SOrganization;
import com.ry.pojo.SRole;
import com.ry.pojo.SUser;

public class UserDto extends SUser{

	private SOrganization org;
	private SRole role;
	
	public SOrganization getOrg() {
		return org;
	}
	public void setOrg(SOrganization org) {
		this.org = org;
	}
	public SRole getRole() {
		return role;
	}
	public void setRole(SRole role) {
		this.role = role;
	}
	
	
}
