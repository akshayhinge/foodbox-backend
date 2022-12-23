package com.foodbox.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.mvc.dao.Userdao;
import com.foodbox.mvc.models.User;

@Service
public class Userservices {

	@Autowired
	private Userdao dao;
	
	public User adduser(User user) {
		return dao.adduser(user);
	}
	
	public List<User> getallusers(){
		return dao.getalluser();
	}
	public User getbyid(Long id) {
		return dao.getbyid(id);
	}
	public String updatebyid(User user,Long id) {
		return dao.updatebyid(id, user);
	}
	public String deletebyid(Long id){
		return dao.deletebyid(id);
	}
	public List<User> login(Long phoneno,String password) {
		return dao.Login(phoneno, password);
	}
}
