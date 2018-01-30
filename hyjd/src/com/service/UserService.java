package com.service;
import java.util.List;

import com.model.User;

public interface UserService {
	/**
	 * 判断用户是否存在
	 */
	public boolean exits(String username);
	/**
	 * 保存用户
	 */
	public void save(User user);
	/**
	 * 修改用户
	 */
	public void modifyUser(User user);
	/**
	 * 删除用户
	 */
	public void deleteUser(Integer id);
	/**
	 * 获取指定id用户
	 */
	public User getUser(Integer id);
	/**
	 * 获取用户列表
	 */
	public List<User> queryUsers(String username);
}
