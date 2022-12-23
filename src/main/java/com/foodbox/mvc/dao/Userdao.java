package com.foodbox.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodbox.mvc.models.Admin;
import com.foodbox.mvc.models.User;
import com.foodbox.mvc.repository.Userrepo;

@Repository
public class Userdao {

	@Autowired
	private Userrepo userrepo;
	
	public User adduser(User user) {
		try {
			return userrepo.saveAndFlush(user);
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public User getbyid(Long id) {
		try {
			Optional<User> data = userrepo.findById(id);
			return data.get();			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public List<User> getalluser(){
		try {
			return userrepo.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public String updatebyid(Long id,User user) {
		try {
			User olduser = userrepo.findById(id).get();
			if (user.getFname()!=null) {
				olduser.setFname(user.getFname());				
			}
			if (user.getLname()!=null) {
				olduser.setLname(user.getLname());				
			}
			if (user.getAddress()!=null) {
				olduser.setAddress(user.getAddress());				
			}
			if (user.getPassword()!=null) {
				olduser.setPassword(user.getPassword());				
			}
			userrepo.saveAndFlush(olduser);
			return "changes save successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String deletebyid(Long id) {
		try {
			userrepo.deleteById(id);
			return "Record deleted successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public List<User> Login(Long phoneno,String password) {
		try {
			List<User> users = userrepo.findByPhonenoAndPassword(phoneno, password);
			if (users.isEmpty()!=true) {
				return users;					
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
}
