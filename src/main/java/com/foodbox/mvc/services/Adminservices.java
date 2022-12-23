package com.foodbox.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.mvc.dao.Admindao;
import com.foodbox.mvc.models.Admin;

@Service
public class Adminservices {

	@Autowired
	private Admindao dao;
	
	public Admin addadmin(Admin admin) {
		return dao.addadmin(admin);
	}
	
	public List<Admin> getalladmins(){
		return dao.getalladmins();
	}
	public Admin getbyid(Long id) {
		return dao.getbyid(id);
	}
	public String updatebyid(Admin admin,Long id) {
		return dao.updatebyid(id, admin);
	}
	public String deletebyid(Long id){
		return dao.deletebyid(id);
	}
	public List<Admin> login(Long phoneno,String password) {
		return dao.Login(phoneno, password);
	}
}
