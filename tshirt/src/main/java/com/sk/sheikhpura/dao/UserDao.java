package com.sk.sheikhpura.dao;

import java.util.List;

import com.sk.sheikhpura.entity.UserInfo;

public interface UserDao {
	public UserInfo findUserById(int id);
	public List<UserInfo> getUsers();
	public UserInfo saveOrUpdateUser(UserInfo user);
	public void deleteeUser(String username);
	public UserInfo findUserByUserName(String username);
}
