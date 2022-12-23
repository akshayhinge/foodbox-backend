package com.foodbox.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.mvc.models.Cart;
import com.foodbox.mvc.services.Cartservice;

@RestController
@RequestMapping("/api/user/cart/")
@CrossOrigin
public class Cartcontroller {
	
	@Autowired
	private Cartservice cartservice;
	
	@GetMapping("{id}")
	public ResponseEntity<?> getcart(@PathVariable("id") Long id){
		Cart cart = cartservice.getcart(id);
		if(cart !=null) {
			return ResponseEntity.ok(cart);
		}
		return new ResponseEntity<String>("Cart not found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{uid}/{pid}")
	public ResponseEntity<?> updatecart(@PathVariable("uid") Long uid,
			@PathVariable("pid") List<Long> pid, 
			@RequestBody Cart cart){
		
		Cart updatedCart = cartservice.updateCart(uid,pid,cart);
		if (updatedCart!=null) {
			return ResponseEntity.ok(updatedCart);
		}
		return new ResponseEntity<String>("Something went wrong..",HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("{uid}")
	public ResponseEntity<?> emptycart(@PathVariable("uid") Long uid){
		
		Cart cart = cartservice.emptycart(uid);
		if (cart!=null) {
			return ResponseEntity.ok(cart);
		}
		return new ResponseEntity<String>("Something went wrong..",HttpStatus.BAD_REQUEST);
	}
	


}
