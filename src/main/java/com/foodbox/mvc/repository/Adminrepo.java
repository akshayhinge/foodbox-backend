package com.foodbox.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodbox.mvc.models.Admin;

public interface Adminrepo extends JpaRepository<Admin, Long>{
	

	public List<Admin> findByPhoneno(String phoneno);
	
	@Query("select a from Admin a where a.phoneno=?1 and a.password=?2")
	public List<Admin> findByPhonenoAndPassword(Long phoneno,String password);
}
