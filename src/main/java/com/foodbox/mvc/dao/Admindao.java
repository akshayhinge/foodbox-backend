package com.foodbox.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodbox.mvc.models.Admin;
import com.foodbox.mvc.repository.Adminrepo;

@Repository
public class Admindao {

	@Autowired
	private Adminrepo adminrepo;

	public Admin addadmin(Admin admin) {
		try {
			return adminrepo.save(admin);
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public Admin getbyid(Long id) {
		try {
			Optional<Admin> data = adminrepo.findById(id);
			return data.get();			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public List<Admin> getalladmins(){
		try {
			return adminrepo.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public String updatebyid(Long id,Admin admin) {
		try {
			Admin oldadmins = adminrepo.findById(id).get();
			if (admin.getFname()!=null) {
				oldadmins.setFname(admin.getFname());				
			}
			if (admin.getLname()!=null) {
				oldadmins.setLname(admin.getLname());				
			}
			if (admin.getAddress()!=null) {
				oldadmins.setAddress(admin.getAddress());				
			}
			if (admin.getPassword()!=null) {
				oldadmins.setPassword(admin.getPassword());				
			}
			adminrepo.saveAndFlush(oldadmins);
			return "changes save successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String deletebyid(Long id) {
		try {
			adminrepo.deleteById(id);
			return "Record deleted successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Admin> Login(Long phoneno,String password) {
		try {
			List<Admin> admin = adminrepo.findByPhonenoAndPassword(phoneno, password);
			if (admin.isEmpty()!=true) {
				return admin;					
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
