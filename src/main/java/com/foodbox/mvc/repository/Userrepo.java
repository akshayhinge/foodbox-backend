package com.foodbox.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.mvc.models.User;

public interface Userrepo extends JpaRepository<User, Long>{


	public List<User> findByPhonenoAndPassword(Long phoneno,String password);
}
