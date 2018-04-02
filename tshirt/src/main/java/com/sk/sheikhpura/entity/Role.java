package com.sk.sheikhpura.entity;

import java.util.Set;

//@Entity
//@Table(name = "USER_ROLE_INFO")
public class Role {
	private int id;
	private String roleName;
	
	private Set<UserInfo> userInfo;

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//@Column(name = "ROLE_NAME", length = 20, nullable = false)
	public String getName() {
		return roleName;
	}

	public void setName(String name) {
		this.roleName = name;
	}

	//@ManyToMany(mappedBy = "roles")
	public Set<UserInfo> getUsers() {
		return userInfo;
	}

	public void setUsers(Set<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}
}
