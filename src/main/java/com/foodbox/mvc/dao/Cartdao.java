 package com.foodbox.mvc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodbox.mvc.models.Cart;
import com.foodbox.mvc.models.Products;
import com.foodbox.mvc.models.User;
import com.foodbox.mvc.repository.Cartrepo;
import com.foodbox.mvc.repository.Productrepo;
import com.foodbox.mvc.repository.Userrepo;

@Repository
public class Cartdao {

	@Autowired
	private Productrepo productrepo;
	
	@Autowired
	private Userrepo userrepo;

	@Autowired
	private Cartrepo cartrepo;

	public Cart getcart(Long id) {
		try {
			User user = userrepo.findById(id).get();
			return user.getCart();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}


	public Cart updatecart(Long uid,List<Long> pid,Cart cart) {
		try {
			User user = userrepo.findById(uid).get();
			
			List<Products> products = new ArrayList<Products>();
			if(pid.isEmpty()) {
				return null;
			}else {
				
				for (Long id : pid) {
					if(id==0) {
						products=null;
						break;
					}else {
						Products product = productrepo.findById(id).get();
						products.add(product);					
					}
				}
			}
			cart.setUser(user);
			cart.setProducts(products);
			
			if(user.getCart()!=null) {
				Cart cart2 = cartrepo.findById(user.getCart().getId()).get();
				cart2.setTotalamount(cart.getTotalamount());
				cart2.setTotalitems(cart.getTotalitems());
				cart2.setProducts(cart.getProducts());
				cartrepo.save(cart2);
			}else{
				user.setCart(cart);
				userrepo.save(user);	
			}
			
			return user.getCart();

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public Cart emptycart(Long uid) {
		try {
			User user = userrepo.findById(uid).get();
				List<Products> products=new ArrayList<Products>();
				Cart cart = user.getCart();
				cart.setTotalamount(0.0);
				cart.setTotalitems(0);
				cart.setProducts(products);
				user.setCart(cart);
				userrepo.save(user);
				return cart;
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
		
		
	}
}
