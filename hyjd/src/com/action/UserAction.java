package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	
	private User user;
	
	private String searchText;
	
	private List<User> users;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String addUser(){
		if(userService.exits(user.getUsername())){
			return ERROR;
		}
		userService.save(user);
		return SUCCESS;
	}
	
	public String queryUser(){
		searchText = getParam("queryText");
		users = userService.queryUsers(searchText);
		return SUCCESS;
	}
	
	public String editUser(){
		try {
			Integer param = Integer.parseInt(getParam("param"));
			if(param == 0){
				Integer id = Integer.parseInt(getParam("id"));
				user = userService.getUser( id);
				return "editUser";
			}else if(param == 1){
				userService.modifyUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String deleteUser(){
		try {
			Integer param = Integer.parseInt(getParam("id"));
			userService.deleteUser(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryUser() ;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
