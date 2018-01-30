package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.model.User;

@Component
public class UserDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(User user){
		hibernateTemplate.save(user);
	}
	public void update(User user){
		hibernateTemplate.update(user);
	}
	public void delete(Integer id){
		User user=getUser(id);
		hibernateTemplate.delete(user);
	}
	public User getUser(Integer id){
		return (User)this.hibernateTemplate.load(User.class,id);
	}
	public List<User> findByUsername(String username){
		return (List<User>) hibernateTemplate.find("from User u where u.username = ?",username);
	}
	public List<User> queryByUsername(String username){
		return (List<User>) hibernateTemplate.find("from User u where u.username like ?","%"+username+"%");
	}
	
	public List<User> findAllUsers(){
		 return this.getHibernateTemplate().find("from User order by id");  
	}

}
