package com.foodbox.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.mvc.models.Cart;

public interface Cartrepo extends JpaRepository<Cart, Long>{
	

}
