package com.foodbox.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.mvc.dao.Cartdao;
import com.foodbox.mvc.models.Cart;
import com.foodbox.mvc.models.Products;

@Service
public class Cartservice {

	@Autowired
	private Cartdao cartdao;
	
	public Cart getcart(Long id) {
		return cartdao.getcart(id);
	}


	public Cart updateCart(Long uid,List<Long> pid,Cart cart) {
		return cartdao.updatecart(uid,pid,cart);
	}
	
	public Cart emptycart(Long uid) {
		return cartdao.emptycart(uid);
	}

}
